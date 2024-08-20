
var HashMap = function () {
    let map = {};
    return {
        put: function (k, v) {
            map[k] = v;
        },
        keys: function () {
            let mapstring = '';
            let mapres = [];
            let keylist = []
            let varlist = []
            for (const key in map) {
                keylist.push(key);
                varlist.push(map[key]);
            }
            for (let i = 0; i < keylist.length; i++) {
                let key = keylist[i];
                let varr = varlist[i];
                let result = key + ':' + varr;
                mapres.push(result);
                mapstring += result + '\n'
            }
            
            return mapstring;
            
        },
        contains: function (k) {
            let res;
            for (const key in map) {
                if (key == k) {
                    res = true
                    return res
                } else {
                    res = false
                }
            }
            // 
            // if(){
            //     res = true;
            // }else{
            //     res = false;
            // }

            return res;
        },
        get: function (k) {
            const keyss = k
            return keyss;
        },
        clear: function () {
            map = {}
        }

    };

};