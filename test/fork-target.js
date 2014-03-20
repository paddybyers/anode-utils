console.log = require('debuglog').log;
console.log('fork target: received args:');
process.argv.forEach(console.log.bind(console));

if(process.argv[2] == 'wait') {
	var wait = Number(process.argv[3]);
	setTimeout(function() { process.exit(2); }, wait);
}
