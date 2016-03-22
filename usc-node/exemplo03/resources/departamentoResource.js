"use strict";

class DepartamentoResource {
  findAll(req, res, next) {
    this.departamentoBusiness = require("../business/departamentoBusiness");
    this.departamentoBusiness.findAll(function callbackDepartamento(rows){
      res.json(rows);
      next();
    });
  }
}
module.exports = new DepartamentoResource();
