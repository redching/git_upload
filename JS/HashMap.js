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
      if (k in map) {
        return true;
      }
      return false;
    },
    get: function (k) {
      return map[k];
    },
    clear: function () {
      map = {};
    },
  };
};
