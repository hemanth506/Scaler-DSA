// Sorting + Greedy TC = O(N log N)

var bagOfTokensScore = function (tokens, power) {
  const n = tokens.length;
  if (n <= 2) {
    if (n === 1) {
      if (power >= tokens[0]) {
        return 1;
      }
      return 0;
    }

    if (power >= tokens[0] || power >= tokens[1]) {
      return 1;
    }
    return 0;
  }
  tokens.sort((a, b) => a - b);
  let i = 0;
  let j = n - 1;
  let score = 0;
  let maxScore = -Infinity;

  while (i <= j) {
    let changed = false
    if (power >= tokens[i]) {
      power -= tokens[i];
      score += 1;
      i++;
      changed = true
    } else if (score >= 1) {
      power += tokens[j];
      score -= 1;
      j--;
      changed = true
    }
    maxScore = Math.max(maxScore, score);
    if (!changed) {
      return 0;
    }
  }
  return maxScore;
};

let tokens, power;

// tokens = [100, 200, 300, 400, 500, 600];
// power = 200;

// tokens = [90, 69, 47];
// power = 10;

tokens = [48, 87, 26];
power = 81;

// tokens = [200, 100]
// power = 150
bagOfTokensScore(tokens, power);
