var numberOfWays = function (corridor) {
    const n = corridor.length, MOD = 1e9 + 7
    let ctTotalSeats = 0, partition = 0, sCt = 0, ct = 0
    for (let i = 0; i < n; i++) {
        if (corridor[i] === 'S') {
            sCt += 1;
            ctTotalSeats += 1;
        }

        if (sCt === 2) {
            partition = (partition === 0) ? 1 : ((partition % MOD) * (ct % MOD)) % MOD
            sCt = 0, ct = 0;
            let j = i + 1
            for (; j < n; j++) {
                if (corridor[j] !== 'P') break;
                ct += 1
            }
            i = j - 1
            ct += 1
        }
    }

    if (ctTotalSeats === 0 || (ctTotalSeats % 2 === 1)) return 0;

    return partition;
};

let corridor;

// corridor = "SSPPPSPPSPPSSPP"
// corridor = "SSPPSPS"
// corridor = "PPSPSP"
// corridor = "S"
// corridor = "SPPPPPPPSPPPSPSSSPPPPPPPPPPPPPPPPPSPPPPPPPPPPPPPPPPSPPPPPSPSPPPPPPSPSPPSPSPPPSPSPPSSPPPPPSPPSSPP"
corridor = "PPPPPSPPSPPSPPPSPPPPSPPPPSPPPPSPPSPPPSPSPPPSPSPPPSPSPPPSPSPPPPSPPPPSPPPSPPSPPPPSPSPPPPSPSPPPPSPSPPPSPPSPPPPSPSPSS"
console.log(numberOfWays(corridor));
