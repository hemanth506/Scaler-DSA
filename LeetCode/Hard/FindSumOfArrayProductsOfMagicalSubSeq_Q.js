// Very hard
var magicalSum = function (m, k, nums) {
    const n = nums.length;
    const MOD = 1000000007n;
    const memo = new Map();

    // Factorials
    let fact = Array(m + 1).fill(1n);
    let invFact = Array(m + 1).fill(1n);

    function modPow(base, exp) {
        base = BigInt(base);
        exp = BigInt(exp);
        if (exp === 0n) return 1n;
        let half = modPow(base, exp / 2n);
        let res = (half * half) % MOD;
        if (exp % 2n === 1n) res = (res * base) % MOD;
        return res;
    }

    function modInverse(x) {
        return modPow(x, MOD - 2n);
    }

    function precomputeFactorials() {
        fact[0] = 1n;
        for (let i = 1; i <= m; i++) fact[i] = (fact[i - 1] * BigInt(i)) % MOD;
        invFact[m] = modInverse(fact[m]);
        for (let i = m - 1; i >= 0; i--) invFact[i] = (invFact[i + 1] * BigInt(i + 1)) % MOD;
    }

    function nCr(n, r) {
        if (r < 0 || r > n) return 0n;
        return (fact[n] * invFact[r] % MOD) * invFact[n - r] % MOD;
    }

    function bitCount(x) {
        let cnt = 0n;
        while (x > 0n) {
            cnt += x & 1n;
            x >>= 1n;
        }
        return cnt;
    }

    function dp(mask, mLeft, kLeft, i) {
        const key = mask + '_' + mLeft + '_' + kLeft + '_' + i;
        if (memo.has(key)) return memo.get(key);

        if (mLeft === 0 && bitCount(mask) === BigInt(kLeft)) return 1n;
        if (i === n) return 0n;

        let total = 0n;

        // Option 1: skip current index
        total = (total + dp(mask >> 1n, mLeft, kLeft - Number(mask & 1n), i + 1)) % MOD;

        // Option 2: pick 1..mLeft copies of nums[i]
        let prod = 1n;
        for (let freq = 1; freq <= mLeft; freq++) {
            prod = (prod * BigInt(nums[i])) % MOD;
            let newMask = (mask >> 1n) + BigInt(freq);
            let newK = kLeft - Number(mask & 1n);
            if (newK < 0) break;
            let val = (prod * nCr(mLeft, freq)) % MOD;
            total = (total + (val * dp(newMask, mLeft - freq, newK, i + 1)) % MOD) % MOD;
        }

        memo.set(key, total);
        return total;
    }

    precomputeFactorials();
    return Number(dp(0n, m, k, 0) % MOD);
};

/** Reference
 * 
 * class Solution {
    static final long MOD = 1_000_000_007;
    int[] nums;
    int n;
    Map<String, Long> memo = new HashMap<>();

    long[] fact, invFact; // precomputed factorials and inverse factorials

    public int magicalSum(int m, int k, int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        
        precomputeFactorials(m); // precompute factorials up to m
        
        return (int) (dp(0, m, k, 0) % MOD);
    }

    private long dp(int mask, int m, int k, int i) {
        if (m == 0 && Integer.bitCount(mask) == k) return 1;
        if (i == n) return 0;

        String key = mask + "," + m + "," + k + "," + i;
        if (memo.containsKey(key)) return memo.get(key);

        long total = 0;

        // Option 1: skip this index
        total = (total + dp(mask / 2, m, k - (mask & 1), i + 1)) % MOD;

        // Option 2: pick 1..m copies of nums[i]
        for (int freq = 1; freq <= m; freq++) {
            int newMask = mask / 2 + freq;
            int newK = k - (mask & 1);
            if (newK < 0) break;
            long val = (modPow(nums[i], freq) * nCr(m, freq)) % MOD;
            total = (total + val * dp(newMask, m - freq, newK, i + 1)) % MOD;
        }

        memo.put(key, total);
        return total;
    }

    // Recursive modular exponentiation
    private long modPow(long base, long exp) {
        if (exp == 0) return 1;
        long half = modPow(base, exp / 2);
        long result = (half * half) % MOD;
        if (exp % 2 == 1) result = (result * base) % MOD;
        return result;
    }

    // Precompute factorials and inverse factorials
    private void precomputeFactorials(int n) {
        fact = new long[n + 1];
        invFact = new long[n + 1];

        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[n] = modInverse(fact[n]);
        for (int i = n - 1; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }
    }

    // nCr using precomputed factorials
    private long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
    }

    // Modular inverse using Fermat's little theorem
    private long modInverse(long x) {
        return modPow(x, MOD - 2);
    }
}
 */
