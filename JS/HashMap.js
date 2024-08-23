var HashMap = function () {
  let map = {};
  return {
    put: function (k, v) {
      map[k] = v;
    },
    keys: function () {
      return Object.keys(map);
    },
    contains: function (k) {
      return k in map;
    },
    get: function (k) {
      return map[k];
    },
    clear: function () {
      map = {};
    },
  };
};
