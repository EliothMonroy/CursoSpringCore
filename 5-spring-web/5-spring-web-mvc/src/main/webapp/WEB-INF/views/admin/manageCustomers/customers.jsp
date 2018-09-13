<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script>
  $(document).ready(function(event) {
    $("a[data-accion=deleteCustomer]").on("click", function(event) {
      event.preventDefault();

      var $this = $(this);
      var tr = $this.parent().parent();

      var id = tr.find("td:first").text();
      var number = tr.find("td:eq(1) a").text();

      swal({
        title: "¿Do you want delete customer: " + number + "?",
        text: "You will not be able to recover this customer and theirs accounts!",
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
</script>

<div id="command-mensaje" class="error">
	${commandMensajeMap[commandMensaje]}
	<%-- <c:forEach items="${commandMensajeMap}" var="commandMensajeMap" varStatus="status">
		<input name="commandMensajeMap['${commandMensajeMap.key}']" value="${commandMensajeMap.value}"/>
    </c:forEach> --%>
</div>

<div id="box">
	<h3>
		<span style="display: inline-block; text-align: left; width: 49%;"> Manage Customers </span>
		<span style="display: inline-block; text-align: right; width: 50%;">
			<a href="${site_url}admin/manage/customers/create"> <span style="font-size: 12px;">Create New Customer</span> <img
					width="16" height="16" src="${site_url}resources/img/icons/user_add.png" title="Create New Customer" />
			</a>
		</span>
	</h3>
	<table data-table="grid">
		<thead>
			<tr>
				<th width="40px">
					<a href="#"> ID <img src="${site_url}resources/img/icons/arrow_down_mini.gif" width="16" height="16"
							align="middle" />
					</a>
				</th>
				<th>
					<a href="#">Name</a>
				</th>
				<th>
					<a href="#">Last Name</a>
				</th>
				<th>
					<a href="#">Username</a>
				</th>
				<th width="100px">
					<a href="#">Actions</a>
				</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="customer" items="${customers}" varStatus="i">
				<tr>
					<td class="a-center">${customer.id}</td>
					<td>
						<a href="#">${customer.name}</a>
					</td>
					<td>
						<a href="#">${customer.lastName}</a>
					</td>
					<td>${customer.user.username}</td>
					<td align="center">
						<c:set var="urlPermiso" value="user" />
						<a href="${site_url}admin/manage/customers/view/${customer.id}"> <img src="resources/img/icons/account.gif"
								title="View Customer Detail" width="16" height="16" />
						</a> &nbsp;&nbsp;&nbsp; <a href="${site_url}admin/manage/customers/edit/${customer.id}"> <img
								src="resources/img/icons/user_edit.png" title="Edit Customer" width="16" height="16" />
						</a> &nbsp;&nbsp;&nbsp; <a href="##" data-accion="deleteCustomer"
							data-urlAccion="${site_url}admin/manage/customers/delete/${customer.id}"> <img
								src="resources/img/icons/user_delete.png" title="Delete Customer" width="16" height="16" />
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div id="pager">
		Página <a href="#"> <img src="resources/img/icons/arrow_left.gif" width="16" height="16" />
		</a>
		<input size="1" value="1" type="text" name="page" id="page" />
		<a href="#"> <img src="resources/img/icons/arrow_right.gif" width="16" height="16" />
		</a> de 50 páginas | Viendo
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