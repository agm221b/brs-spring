<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form method="post" action="paymentdetails">
Payment Details:
<br/>
<input type="radio" name="paymentMode" value="UPI">UPI
<input type="radio" name="paymentMode" value="Debit Card">Debit Card
<input type="radio" name="paymentMode" value="Credit Card">Credit Card
<input type="radio" name="paymentMode" value="Net Banking">Net Banking
<input type="radio" name="paymentMode" value="e-Wallets">e-Wallets
<input type="submit" value="Proceed">
</form>
</body>
</html>