var noop = function() {};
var debuglog = require('debuglog');
console.log = debuglog.log;
console.error = debuglog.error;
console.log('starting fork-test ...');

var child_process = require('anodeutils_child_process');
console.log('child_process: ' + require('util').inspect(child_process));

function test1(callback) {
	callback = callback || noop;
	try {
		var child = child_process.fork('/sdcard/fork-target.js', 'The quick brown fox'.split(' '));
		console.log('child: ' + require('util').inspect(child));
	
		child.on('exit', function() {
			console.log('child process exited');
			callback(null);
		});
	
	} catch(e) {
		console.log('Unexpected error forking child process: err = ' + e.stack);
		callback(e);
	}
}

function test2(callback) {
	callback = callback || noop;
	try {
		var child = child_process.fork('/sdcard/fork-target.js', 'wait 8000'.split(' '));
		console.log('child: ' + require('util').inspect(child));

		var startTime = Date.now();
		setTimeout(function() {
			console.log('killing ...');
			try {
				child.kill();
				console.log('... back');
			} catch(e) {
				console.log('Unexpected error killing child process: err = ' + e.stack);
				callback(e);
			}
		}, 1000);

		child.on('exit', function() {
			var endTime = Date.now();
			console.log('child process exited in ' + (endTime - startTime) + 'ms');
		});
	
	} catch(e) {
		console.log('Unexpected error forking child process: err = ' + e.stack);
		callback(e);
	}
}

test1(function(err) {
	test2();
});
