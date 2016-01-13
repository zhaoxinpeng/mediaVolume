

var exec = require('cordova/exec');

// module.exports = {
// 	setVol: function(arg0, success, error) {
//     	exec(success, error, "mediaVolume", "setVol", [arg0]);
// 	},
// 	getVol: function(success, error){
// 		exec(success, error, "mediaVolume", "getVol", []);
// 	}
// };

var mediaVolume = {
	setVol: function(arg0, success, error) {
    	exec(success, error, "mediaVolume", "setVol", [arg0]);
	},
	getVol: function(success, error){
		exec(success, error, "mediaVolume", "getVol", []);
	}
}
window.plugins = window.plugins || {};
window.plugins.mediaVolume = mediaVolume;
exports.mediaVolume = mediaVolume;