/*! jQuery JSON to Table - v1.1.3 - 2014-10-11
 * https://github.com/jongha/jquery-jsontotable
 * Copyright (c) 2014 Jong-Ha Ahn; Licensed MIT */
! function(a) {
    a.jsontotable = function(b, c) {
        var d = a.extend({
            id: null,
            header: !0,
            className: null
        }, c);
        c = a.extend(d, c);
        var e = b;
        if ("string" == typeof e && (e = a.parseJSON(e)), c.id && e.length) {
            var f, g, h = a("<table></table>");
            c.className && h.addClass(c.className), a.fn.appendTr = function(b, c) {
                var d, e, f, h, i, j = c ? "thead" : "tbody",
                    k = c ? "th" : "td";
                if (a.isPlainObject(b) && b._data) {
                    g = "<tr";
                    for (d in b) "_data" !== d && (g += " " + d + '="' + b[d] + '"');
                    g += "></tr>", b = b._data
                } else g = "<tr></tr>";
                g = a(g);
                for (e in b)
                    if (f = b[e], "function" != typeof f) {
                        if (h = "", a.isPlainObject(f) && f._data) {
                            h = "<" + k;
                            for (i in f) "_data" !== i && (h += " " + i + '="' + f[i] + '"');
                            f = f._data, h += ">" + f + "</" + k + ">"
                        } else h = "<" + k + ">" + f + "</" + k + ">";
                        g.append(h)
                    }
                if (c) a(this).append(a("<" + j + "></" + j + ">").append(g));
                else {
                    var l = a(this).find("tbody");
                    0 === l.length && (l = a(this).append("<tbody></tbody>")), l.append(g)
                }
                return this
            };
            var i = function(a) {
                    if (null == a || "object" != typeof a) return a;
                    var b = a.constructor();
                    for (var c in a) a.hasOwnProperty(c) && (b[c] = i(a[c]));
                    return b
                },
                j = !1,
                k = {},
                l = null;
            if (c.header) {
                if (k = i(e[0]._data ? e[0]._data : e[0]), "[object Object]" === k.toString()) {
                    j = !0;
                    for (l in k) k[l] = l
                }
                h.appendTr(k, !0)
            }
            for (f = c.header ? 1 : 0; f < e.length; f++)
                if (j && k) {
                    var m = {};
                    for (l in k) m[l] = e[f] && null != e[f][l] ? e[f][l] : "";
                    h.appendTr(m, !1)
                } else h.appendTr(e[f], !1);
            a(c.id).append(h)
        }
        return this
    }
}(jQuery);