<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>

<div class="container">

    <div id="piv" v-cloak>

        <script type="text/html" id="dados-usuario">

            <div>
                <div class="page-header">
                    <h1>Simulador PIV</h1>
                </div>
                <table class="table small table-bordered table-condensed">
                    <tbody>
                        <tr>
                            <th class="row"><label for="nome">Nome:</label></th>
                            <td><span id="nome" v-text="vm.piv.op.nome"></span></td>
                        </tr>
                        <tr>
                            <th class="row"><label for="super">Supervisão:</label></th>
                            <td><span id="super" v-text="vm.piv.op.nomeSupervisor"></span></td>
                        </tr>
                        <tr>
                            <th class="row"><label for="equipe">Equipe:</label></th>
                            <td><span id="equipe" v-text="vm.piv.op.equipe"></span></td>
                        </tr>
                    </tbody>
                </table>
            </div>

            </script>

            <script type="text/html" id="simulator">

                <div class="row">
                    <div class="col-xs-3">
                        <div class="form-group">
                            <label for="fcr">FCR</label>
                            <div class="input-group">
                                <input id="fcr" type="number" v-model="vm.fcr" min="0" max="100" class="form-control" placeholder="FCR" aria-describedby="fcr-addon1">
                                <span class="input-group-addon" id="fcr-addon1">%</span>
                            </div>
                        </div>
                    </div>

                    <div class="col-xs-3">
                        <div class="form-group">
                            <label for="adr">Aderência</label>
                            <div class="input-group">
                                <input id="adr" v-model="vm.adr" type="number"  min="0" max="100" class="form-control" placeholder="Aderência" aria-describedby="adr-addon1">
                                <span class="input-group-addon" id="adr-addon1">%</span>
                            </div>
                        </div>
                    </div>

                    <div class="col-xs-3">
                        <div class="form-group">
                            <label for="monitoria">Monitoria</label>
                            <div class="input-group">
                                <input v-model="vm.monitoria"  id="monitoria" type="number" min="0" max="100" class="form-control" placeholder="Monitoria" aria-describedby="fcr-addon1">
                                <span class="input-group-addon" id="monitoria-addon1"><span class="glyphicon glyphicon-headphones" aria-hidden="true"></span></span>
                            </div>
                        </div>
                    </div>

                    <div class="col-xs-3">
                        <div class="form-group">
                            <label for="tma">TMA</label>
                            <div class="input-group">
                                <input v-model="vm.tma" id="tma" type="time" class="form-control" placeholder="TMA" aria-describedby="tma-addon1">
                                <span class="input-group-addon" id="basic-tma"><span class="glyphicon glyphicon-dashboard" aria-hidden="true"></span></span>
                            </div>
                        </div>
                    </div>

                    <div class="col-xs-3">
                        <div class="form-group">
                            <label for="tma">GPS</label>
                            <div class="input-group">
                                <input v-model="vm.gps" id="gps" type="number" min="0" max="100" class="form-control" placeholder="GPS" aria-describedby="tma-addon1">
                                <span class="input-group-addon" id="basic-tma">%</span>
                            </div>
                        </div>
                    </div>

                    <div class="col-xs-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <span>Target</span>
                            </div>
                            <div class="panel-body">
                                <h2 class="text-center"><span v-text="vm.piv.target * 100"></span>%</h2>
                            </div>
                        </div>
                    </div>

                    <div class="col-xs-3">
                        <button type="button" class="btn btn-warning">Limpar</button>
                    </div>
                </div>
                </script>

                <transition name="fade">
                    <div>
                        <div v-show="show">
                            <dados-user></dados-user>
                            <hr>
                            <simulador-form></simulador-form>
                        </div>
                        <div v-show="!show">
                            <p> </p>
                            <img class="center-block" src="/resources/custom/gif/rolling.gif">
                        </div>
                    </div>
                </transition>

            </div>
        </div>

        <script src="${pageContext.request.contextPath}/resources/vue-components/simuladorpiv/simulador.js"></script>
