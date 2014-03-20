(function() {
	var EventEmitter = require('events').EventEmitter;
	var util = require('util');
	var ChildProcessImpl = require('bridge').load('org.meshpoint.anodeutils.ChildProcessImpl', {});

	function Child() {
		EventEmitter.call(this);
	}
	util.inherits(Child, EventEmitter);

	Child.prototype.onExit = function(exitval) {
		this.emit('exit', exitval);
	};

	Child.prototype.onMessage = function(msg) {
		this.emit('message', msg);
	};

	Child.prototype.kill = function(sig) {
		var proxy = this.proxy;
		if(!proxy)
			throw new Error('Unable to kill process that has not been started');

		proxy.kill(sig);
	};

	function fork(modulePath, args) {
		var child = new Child();
		child.proxy = ChildProcessImpl.fork(modulePath, args, child);
		return child;
	}

	this.fork = fork;
}).call(exports);