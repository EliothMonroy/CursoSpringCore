<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="rightnow">
	<h3 class="reallynow">
		<span>Right Now</span> <a href="#" class="add">Add New Product</a> <a
			href="#" class="app_add">Some Action</a> <br />
	</h3>
	<p class="youhave">
		You have <a href="#">19 new orders</a>, <a href="#">12 new users</a>
		and <a href="#">5 new reviews</a>, today you made <a href="#">$1523.63
			in sales</a> and a total of <strong>$328.24 profit </strong>
	</p>
</div>
<div id="infowrap">
	<div id="infobox">
		<h3>Sales for July</h3>
		<p>
			<img src="resources/img/graph.jpg" width="360" height="266" />
		</p>
	</div>
	<div id="infobox" class="margin-left">
		<h3>Traffic for July</h3>
		<p>
			<img src="resources/img/graph2.jpg" alt="a" width="359" height="266" />
		</p>
	</div>
	<div id="infobox">
		<h3>Last 5 Orders</h3>
		<table>
			<thead>
				<tr>
					<th>Customer</th>
					<th>Items</th>
					<th>Grand Total</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><a href="#">Jennifer Kyrnin</a></td>
					<td>1</td>
					<td>14.95 $</td>
				</tr>
				<tr>
					<td><a href="#">Mark Kyrnin</a></td>
					<td>2</td>
					<td>34.27 $</td>
				</tr>
				<tr>
					<td><a href="#">Virgílio Cezar</a></td>
					<td>2</td>
					<td>61.39 $</td>
				</tr>
				<tr>
					<td><a href="#">Todd Simonides</a></td>
					<td>5</td>
					<td>1472.56 $</td>
				</tr>
				<tr>
					<td><a href="#">Carol Elihu</a></td>
					<td>1</td>
					<td>9.95 $</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div id="infobox" class="margin-left">
		<h3>Bestsellers</h3>
		<table>
			<thead>
				<tr>
					<th>Product Name</th>
					<th>Price</th>
					<th>Orders</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><a href="#">Apple iPhone 3G 8GB</a></td>
					<td>199.00 $</td>
					<td>24</td>
				</tr>
				<tr>
					<td><a href="#">Fuji FinePix S5800</a></td>
					<td>365.24 $</td>
					<td>19</td>
				</tr>
				<tr>
					<td><a href="#">Canon PIXMA MP140</a></td>
					<td>59.50 $</td>
					<td>12</td>
				</tr>
				<tr>
					<td><a href="#">Apple iPhone 3G 16GB</a></td>
					<td>199.00 $</td>
					<td>10</td>
				</tr>
				<tr>
					<td><a href="#">Prenosnik HP 530 1,6GHz</a></td>
					<td>499.00 $</td>
					<td>6</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div id="infobox">
		<h3>New Customers</h3>
		<table>
			<thead>
				<tr>
					<th>Customer</th>
					<th>Orders</th>
					<th>Average</th>
					<th>Total</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><a href="#">Jennifer Kyrnin</a></td>
					<td>1</td>
					<td>5.6$</td>
					<td>14.95 $</td>
				</tr>
				<tr>
					<td><a href="#">Mark Kyrnin</a></td>
					<td>2</td>
					<td>14.97$</td>
					<td>34.27 $</td>
				</tr>
				<tr>
					<td><a href="#">Virgílio Cezar</a></td>
					<td>2</td>
					<td>15.31$</td>
					<td>61.39 $</td>
				</tr>
				<tr>
					<td><a href="#">Todd Simonides</a></td>
					<td>5</td>
					<td>502.61$</td>
					<td>1472.56 $</td>
				</tr>
				<tr>
					<td><a href="#">Carol Elihu</a></td>
					<td>1</td>
					<td>5.1$</td>
					<td>9.95 $</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div id="infobox" class="margin-left">
		<h3>Last 5 Reviews</h3>
		<table>
			<thead>
				<tr>
					<th>Reviewer</th>
					<th>Product</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><a href="#">Jennifer Kyrnin</a></td>
					<td><a href="#">Apple iPhone 3G 8GB</a></td>
					<td><a href="#"><img
							src="resources/img/icons/page_white_link.png" /></a><a href="#"><img
							src="resources/img/icons/page_white_edit.png" /></a><a href="#"><img
							src="resources/img/icons/page_white_delete.png" /></a></td>
				</tr>
				<tr>
					<td><a href="#">Mark Kyrnin</a></td>
					<td><a href="#">Prenosnik HP 530 1,6GHz</a></td>
					<td><a href="#"><img
							src="resources/img/icons/page_white_link.png" /></a><a href="#"><img
							src="resources/img/icons/page_white_edit.png" /></a><a href="#"><img
							src="resources/img/icons/page_white_delete.png" /></a></td>
				</tr>
				<tr>
					<td><a href="#">Virgílio Cezar</a></td>
					<td><a href="#">Fuji FinePix S5800</a></td>
					<td><a href="#"><img
							src="resources/img/icons/page_white_link.png" /></a><a href="#"><img
							src="resources/img/icons/page_white_edit.png" /></a><a href="#"><img
							src="resources/img/icons/page_white_delete.png" /></a></td>
				</tr>
				<tr>
					<td><a href="#">Todd Simonides</a></td>
					<td><a href="#">Canon PIXMA MP140</a></td>
					<td><a href="#"><img
							src="resources/img/icons/page_white_link.png" /></a><a href="#"><img
							src="resources/img/icons/page_white_edit.png" /></a><a href="#"><img
							src="resources/img/icons/page_white_delete.png" /></a></td>
				</tr>
				<tr>
					<td><a href="#">Carol Elihu</a></td>
					<td><a href="#">Prenosnik HP 530 1,6GHz</a></td>
					<td><a href="#"><img
							src="resources/img/icons/page_white_link.png" /></a><a href="#"><img
							src="resources/img/icons/page_white_edit.png" /></a><a href="#"><img
							src="resources/img/icons/page_white_delete.png" /></a></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>