"use strict";

class DepartamentoBusiness{
  findAll(callbackDepartamento){
    this.session = require("../factory/sessionFactory");
    this.session.connect();
    this.session.connection.query('SELECT * FROM STATE',
    function(err, rows, fields) {
      if (err) throw err;
      callbackDepartamento(rows);
      this.session.end();
    });
  }
}
module.exports = new DepartamentoBusiness();
