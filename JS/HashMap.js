
var HashMap = function () {
    let map = {};
    return {
        put: function (k, v) {
            map[k] = v;
        },
        keys: function () {
            let keylist = [];
            for (const key in map) {
                keylist.push(key);
            }
            return keylist;

        },
        contains: function (k) {
            for (const key in map) {
                if (key == k) {
                    return true;
                }
            }
            return false;
        },
        get: function (k) {//*
            return map[k];
        },
        clear: function () {
            map = {};
        }

    }

}