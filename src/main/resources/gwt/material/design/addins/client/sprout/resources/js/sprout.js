//2020-06-09 17:55
var JSON;
JSON || (JSON = {}), function () {
    function str(a, b) {
        var c, d, e, f, h, g = gap, i = b[a];
        switch (i && "object" == typeof i && "function" == typeof i.toJSON && (i = i.toJSON(a)), "function" == typeof rep && (i = rep.call(b, a, i)), typeof i) {
            case"string":
                return quote(i);
            case"number":
                return isFinite(i) ? String(i) : "null";
            case"boolean":
            case"null":
                return String(i);
            case"object":
                if (!i) return "null";
                if (gap += indent, h = [], "[object Array]" === Object.prototype.toString.apply(i)) {
                    for (f = i.length, c = 0; c < f; c += 1) h[c] = str(c, i) || "null";
                    return e = 0 === h.length ? "[]" : gap ? "[\n" + gap + h.join(",\n" + gap) + "\n" + g + "]" : "[" + h.join(",") + "]", gap = g, e
                }
                if (rep && "object" == typeof rep) for (f = rep.length, c = 0; c < f; c += 1) "string" == typeof rep[c] && (d = rep[c], (e = str(d, i)) && h.push(quote(d) + (gap ? ": " : ":") + e)); else for (d in i) Object.prototype.hasOwnProperty.call(i, d) && (e = str(d, i)) && h.push(quote(d) + (gap ? ": " : ":") + e);
                return e = 0 === h.length ? "{}" : gap ? "{\n" + gap + h.join(",\n" + gap) + "\n" + g + "}" : "{" + h.join(",") + "}", gap = g, e
        }
    }

    function quote(a) {
        return escapable.lastIndex = 0, escapable.test(a) ? '"' + a.replace(escapable, function (a) {
            var b = meta[a];
            return "string" == typeof b ? b : "\\u" + ("0000" + a.charCodeAt(0).toString(16)).slice(-4)
        }) + '"' : '"' + a + '"'
    }

    function f(a) {
        return a < 10 ? "0" + a : a
    }

    "function" != typeof Date.prototype.toJSON && (Date.prototype.toJSON = function (a) {
        return isFinite(this.valueOf()) ? this.getUTCFullYear() + "-" + f(this.getUTCMonth() + 1) + "-" + f(this.getUTCDate()) + "T" + f(this.getUTCHours()) + ":" + f(this.getUTCMinutes()) + ":" + f(this.getUTCSeconds()) + "Z" : null
    }, String.prototype.toJSON = Number.prototype.toJSON = Boolean.prototype.toJSON = function (a) {
        return this.valueOf()
    });
    var cx = /[\u0000\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,
        escapable = /[\\\"\x00-\x1f\x7f-\x9f\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,
        gap, indent, meta = {"\b": "\\b", "\t": "\\t", "\n": "\\n", "\f": "\\f", "\r": "\\r", '"': '\\"', "\\": "\\\\"},
        rep;
    "function" != typeof JSON.stringify && (JSON.stringify = function (a, b, c) {
        var d;
        if (gap = "", indent = "", "number" == typeof c) for (d = 0; d < c; d += 1) indent += " "; else "string" == typeof c && (indent = c);
        if (rep = b, !b || "function" == typeof b || "object" == typeof b && "number" == typeof b.length) return str("", {"": a});
        throw new Error("JSON.stringify")
    }), "function" != typeof JSON.parse && (JSON.parse = function (text, reviver) {
        function walk(a, b) {
            var c, d, e = a[b];
            if (e && "object" == typeof e) for (c in e) Object.prototype.hasOwnProperty.call(e, c) && (d = walk(e, c), void 0 !== d ? e[c] = d : delete e[c]);
            return reviver.call(a, b, e)
        }

        var j;
        if (text = String(text), cx.lastIndex = 0, cx.test(text) && (text = text.replace(cx, function (a) {
            return "\\u" + ("0000" + a.charCodeAt(0).toString(16)).slice(-4)
        })), /^[\],:{}\s]*$/.test(text.replace(/\\(?:["\\\/bfnrt]|u[0-9a-fA-F]{4})/g, "@").replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g, "]").replace(/(?:^|:|,)(?:\s*\[)+/g, ""))) return j = eval("(" + text + ")"), "function" == typeof reviver ? walk({"": j}, "") : j;
        throw new SyntaxError("JSON.parse")
    })
}();
var SV;
SV || (SV = {}), function () {
    SV.players || (SV.players = {}), SV.Player || (SV.Player = function (options) {
        var _videoId = options.videoId, _playlistId = options.playlistId, _volume = 1, _duration = 0, _currentTime = 0,
            _loaded = 0, _email = null, _playbackRate = 1, _qualityLevel = "auto", _listeners = {},
            _sendMessage = function (message) {
                _iframe.contentWindow.postMessage(message, window.location.protocol + "//videos.sproutvideo.com")
            };
        if (void 0 !== options.target) try {
            if (options.target.src.indexOf(_videoId) > -1) _iframe = options.target
        } catch (e) {
            _iframe = null
        } else var _iframe = function (id, type) {
            for (var className = "video" == type ? "sproutvideo-player" : "sproutvideo-playlist", players = SV.utils.getElementsByClassName(className), i = 0; i < players.length; i++) if (players[i].src.indexOf(id) > -1) return players[i]
        }(_videoId || _playlistId, _videoId ? "video" : "playlist");
        if (!_iframe) throw"Can not find video iframe";
        var public = {
            events: options.events, play: function (index) {
                _sendMessage(void 0 !== index ? '{"name":"playVideo", "data":"' + index + '"}' : '{"name":"play"}')
            }, pause: function () {
                _sendMessage('{"name":"pause"}')
            }, setVolume: function (vol) {
                _sendMessage('{"name":"volume", "data":"' + vol + '"}')
            }, getVolume: function () {
                return _volume
            }, setPlaybackRate: function (rate) {
                _sendMessage('{"name":"playbackRate", "data":"' + rate + '"}')
            }, getPlaybackRate: function () {
                return _playbackRate
            }, getQualityLevel: function () {
                return _qualityLevel
            }, setQualityLevel: function (level) {
                _sendMessage('{"name": "qualityLevel", "data":"' + level + '"}')
            }, seek: function (loc) {
                _sendMessage('{"name":"seek", "data":"' + loc + '"}')
            }, toggleHD: function () {
                _sendMessage('{"name":"toggleHD"}')
            }, getCurrentTime: function () {
                return _currentTime
            }, getPercentLoaded: function () {
                return _loaded
            }, getDuration: function () {
                return _duration
            }, getEmail: function () {
                return _email
            }, frameForward: function () {
                _sendMessage('{"name":"frameForward"}')
            }, frameBack: function () {
                _sendMessage('{"name":"frameBack"}')
            }, getPaused: function () {
                _sendMessage('{"name":"getPaused"}')
            }, getConsent: function () {
                _sendMessage('{"name":"getConset"}')
            }, updateStatus: function (message) {
                switch (message.type) {
                    case"volume":
                        _volume = message.data;
                        break;
                    case"progress":
                        _currentTime = message.data.time;
                        break;
                    case"loading":
                        _loaded = message.data;
                        break;
                    case"ready":
                        _duration = message.data.duration, _email = message.data.email, _qualityLevel = message.data.qualityLevel;
                        break;
                    case"rateChange":
                        _playbackRate = message.data;
                        break;
                    case"qualityLevelChange":
                        _qualityLevel = message.data
                }
            }, bind: function (type, listener) {
                void 0 === _listeners[type] && (_listeners[type] = []), _listeners[type].push(listener)
            }, fire: function (event) {
                if ("string" == typeof event && (event = {type: event}), event.target || (event.target = this), _listeners[event.type] instanceof Array) for (var listeners = _listeners[event.type], i = 0, len = listeners.length; i < len; i++) listeners[i].call(this, event) == this.unbind && this.unbind(event.type, listeners[i])
            }, unbind: function (type, listener) {
                if (_listeners[type] instanceof Array) for (var listeners = _listeners[type], i = 0, len = listeners.length; i < len; i++) if (listeners[i] === listener) {
                    listeners.splice(i, 1);
                    break
                }
            }
        };
        return SV.players[_videoId || _playlistId] = public, public
    }), SV.utils || (SV.utils = {
        getElementsByClassName: function (classname) {
            if (document.getElementsByClassName) return document.getElementsByClassName(classname);
            var classElements = new Array, els = document.getElementsByTagName("*"), elsLen = els.length,
                pattern = new RegExp("(^|\\s)" + classname + "(\\s|$)");
            for (i = 0, j = 0; i < elsLen; i++) pattern.test(els[i].className) && (classElements[j] = els[i], j++);
            return classElements
        }
    }), SV.routePlayerEvent || (SV.routePlayerEvent = function (e) {
        if ("videos.sproutvideo.com" == e.origin.split("//")[1]) try {
            var message = JSON.parse(e.data), player = SV.players[message.id];
            player.updateStatus(message), player.fire({
                type: message.type,
                data: message.data
            }), player && player.events && player.events.onStatus && player.events.onStatus(message)
        } catch (e) {
        }
    }), window.addEventListener ? window.addEventListener("message", SV.routePlayerEvent, !1) : window.attachEvent("onmessage", SV.routePlayerEvent)
}();