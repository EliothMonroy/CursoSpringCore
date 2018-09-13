<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script>
  $(document).ready(function(event) {
    $("a[data-accion=deleteAccount]").on("click", function(event) {
      event.preventDefault();

      var $this = $(this);
      var tr = $this.parent().parent();

      var id = tr.find("td:first").text();
      var number = tr.find("td:eq(1) a").text();

      swal({
        title: "¿Do you want delete account number: " + number + "?",
        text: "You will not be able to recover this account!",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "Yes, delete it!",
        closeOnConfirm: true
      }, function() {
        setTimeout(function() {
          util.doAjax($this.attr('data-urlAccion'), 'DELETE', {}, function(r) {

            util.showCommandMensaje(r.message, true, function($scmc) {
              tr.remove();
            });

            swal("Deleted!", r.message, "success");

          }, function(r) {

            util.showCommandMensaje(r.message, true, function() {
              console.log(r.message);
            });

            swal("Error!", r.message, "error");

          });
        }, 200);

      });

    });
  });

  /*$(document).ready(function(event) {
    $("a[data-accion=deleteAccount]").on("click", function(event) {
      event.preventDefault();

      var $this = $(this);
      var tr = $this.parent().parent();

      var id = tr.find("td:first").text();
      var number = tr.find("td:eq(1) a").text();

      if (confirm("¿Do you want delete account number: " + number + "?")) {
        setTimeout(function() {
          util.doAjax($this.attr('data-urlAccion'), 'DELETE', {}, function(r) {

            util.showCommandMensaje(r.response.mensaje, true, function($scmc) {
              tr.remove();
            });
          }, function() {
            util.showCommandMensaje("No fué posible ejecutar esta acción en este momento", true, function() {
              console.log('error =(');
            });
          });
        }, 200);
      }
    });
  });*/
</script>

<div id="command-mensaje" class="error">
	${commandMensajeMap[commandMensaje]}
	<%-- <c:forEach items="${commandMensajeMap}" var="commandMensajeMap" varStatus="status">
		<input name="commandMensajeMap['${commandMensajeMap.key}']" value="${commandMensajeMap.value}"/>
    </c:forEach> --%>
</div>

<div id="box">
	<h3>
		<span style="display: inline-block; text-align: left; width: 49%;"> Manage Accounts </span>
		<span style="display: inline-block; text-align: right; width: 50%;">
			<a href="${site_url}customer/manage/accounts/create"> <span style="font-size: 12px;">Create New Account</span> <img
					width="16" height="16" src="${site_url}resources/img/icons/user_add.png" title="Create New Account" />
			</a>
		</span>
	</h3>
	<table data-table="grid">
		<thead>
			<tr>
				<th width="40px">
					<a href="#">ID <img src="${site_url}resources/img/icons/arrow_down_mini.gif" width="16" height="16"
							align="middle" /></a>
				</th>
				<th>
					<a href="#">Number</a>
				</th>
				<th>
					<a href="#">Created Date</a>
				</th>
				<th>
					<a href="#">Balance</a>
				</th>
				<th width="100px">
					<a href="#">Actions</a>
				</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="account" items="${accounts}" varStatus="i">
				<tr>
					<spring:eval expression="new java.text.DecimalFormat('$ ###,###,###,###.00')" var="currencyFormat" />
					<spring:eval expression="currencyFormat.format(${account.balance}).toString()" var="balance" />

					<td class="a-center">${account.id}</td>
					<td>
						<a href="#">${account.accountNumber}</a>
					</td>
					<td>${account.createdDate}</td>
					<td>${balance}</td>
					<td align="center">
						<c:set var="urlPermiso" value="user" />
						<a href="${site_url}customer/manage/accounts/view/${account.id}"> <img src="resources/img/icons/account.gif"
								title="View Account Detail" width="16" height="16" />
						</a> &nbsp;&nbsp;&nbsp; <a href="${site_url}customer/manage/accounts/transfer/${account.id}"> <img
								src="resources/img/icons/user_edit.png" title="Transfer Money" width="16" height="16" />
						</a> &nbsp;&nbsp;&nbsp; <a href="##" data-accion="deleteAccount"
							data-urlAccion="${site_url}customer/manage/accounts/delete/${account.id}"> <img
								src="resources/img/icons/user_delete.png" title="Delete Account" width="16" height="16" />
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div id="pager">
		Página <a href="#"><img src="resources/img/icons/arrow_left.gif" width="16" height="16" /></a>
		<input size="1" value="1" type="text" name="page" id="page" />
		<a href="#"><img src="resources/img/icons/arrow_right.gif" width="16" height="16" /></a>de 50 páginas | Viendo
		<select name="view">
			<option>10</option>
			<option>20</option>
			<option>50</option>
			<option>100</option>
		</select>
		registros por página | Total <strong>420</strong> registros encontrados.
	</div>
</div>
<br />