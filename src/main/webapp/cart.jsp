<%@page import="java.text.NumberFormat"%>
<%@page import="database.ConnectDB"%>
<%@page import="dao.Dao"%>
<%@page import="java.util.List"%>
<%@page import="modal.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/cart.css">
    <link rel="stylesheet" href="./css/grid.css">
    <link rel="stylesheet" href="./css/base.css">
    <link rel="stylesheet" href="./css/main.css">
    <link rel="stylesheet" href="./fonts/fontawesome-free-6.1.0-web/css/all.min.css">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>
	<link type="text/css" rel="stylesheet" href="css/slick.css"/>
	<link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>
    <link type="text/css" rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="./fonts/fontawesome-webfont.svg">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css" integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>Electro - HTML Ecommerce Template</title>
</head>
<body>
    <div class="app">
        <jsp:include page="header.jsp"></jsp:include>

        <!-- View Cart -->
        <div class="cart">
            <div class="grid wide cart-wrap">
                <h1 class="cart__heading">My Cart</h1>
                <div class="row">
                    <div class="col l-8">
                        <div class="row">
                        	<%
                        		Dao dao = new Dao();
                        		NumberFormat nf = NumberFormat.getInstance();
                        		nf.setMinimumIntegerDigits(0);
                        		double total = 0;
                        		ArrayList<Cart> cart = null;
                        		if(session.getAttribute("cart") != null) {
                        			cart = (ArrayList<Cart>) session.getAttribute("cart");
                        		}
                        	%>
                        	<% 
                        		if(cart != null) {
                        			for(Cart c : cart) {
                        				total = total + (c.getQuantity() 
                        						* dao.getProductById(c.getP().getId()).getPrice());
                        	%>
                                  <div class="col l-12">
                                    <div class="cart-body">
                                        <div class="cart-body__one">
                                            <img src=<%= dao.getProductById(c.getP().getId()).getImage() %> alt="" class="cart-img">
                                            <div class="cart-content">
                                                <span class="cart-content__name"><%=dao.getProductById(c.getP().getId()).getName()%></span>
                                                <span class="cart-content__price">$<%=nf.format(dao.getProductById(c.getP().getId()).getPrice())%></span>
                                            </div>
                                        </div>
                                        <div class="cart-body__two">
                                            <div class="cart-quantity">
                                                <a href="cart?command=deleteCart&id=<%=c.getP().getId() %>" class="cart-quantity__icon">
                                                    <i class="cart-quantity__icon-link fa-solid fa-minus"></i>
                                                </a>
                                                <span class="cart-quantity__number"><%=c.getQuantity()%></span>
                                                <a href="cart?command=addFromCart&id=<%=c.getP().getId() %>" class="cart-quantity__icon">
                                                    <i class="cart-quantity__icon fa-solid fa-plus"></i>
                                                </a>
                                            </div>
                                            <div class="cart__sum-price">
                                                <i class="cart__sum-price-icon fa-light fa-dollar-sign"></i>
                                                <%=nf.format(dao.getProductById(c.getP().getId()).getPrice() * c.getQuantity()) %>
                                            </div>
                                            <div class="cart-close">
                                                <a href="cart?command=removeCart&id=<%=c.getP().getId() %>" class="cart-close__icon">
                                                    <i class="cart-close__icon-link fa-solid fa-xmark"></i>
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                        			<%
                        		}
                        			
									}
								%>
                        </div>
                    </div>
                    <div class="col l-4">
                        <div class="pay" style="padding: 0 20px 20px 20px">
                            <h3 class="pay__heading">Order</h3>
                            <div class="pay__total">
                                <span class="pay__total-name">Total:</span>
                                <div class="pay__total-price">
                                    <i class="pay__total-price-icon fa-regular fa-dollar-sign"></i>
                                    <%=nf.format(total)%>
                                </div>
                            </div>
                            <a href="checkout.jsp" class="pay__btn">Checkout</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- section help -->
        <div class="help">
            <div class="help-content">
                <div class="help-body">
                    <h3 class="help-body__heading">Need Help? Check Out Our Help Center</h3>
                    <span class="help-body__text">I'm a paragraph. Click here to add your own text and edit me. Let your users get to know you.</span>
                    <a href="https://www.wix.com/website-template/view/html/2860?siteId=29afdded-dd99-4657-8e90-e779027c13c6&metaSiteId=b13ae6bf-ed09-484d-a708-707c0bd807e7&originUrl=https%3A%2F%2Fwww.wix.com%2Fwebsite%2Ftemplates%2Fhtml%2Fnew%2F2&tpClick=view_button#" class="help-body__btn">Go to Help Center</a>
                </div>
            </div>
                
            <div class="help-img">
                <img src="https://static.wixstatic.com/media/c22c23_de5cbbefa9104fc1a1604ea146ea523a~mv2.jpg/v1/fill/w_775,h_556,al_t,q_85,usm_0.66_1.00_0.01,enc_auto/c22c23_de5cbbefa9104fc1a1604ea146ea523a~mv2.jpg" alt="" class="help-img__icon">
            </div>
        </div>

        <!-- Footer -->
        <footer class="footer">
            <div class="grid wide">
                <div class="row footer-content">
                    <div class="col-l-3">
                        <div class="footer__body">
                            <h3 class="footer__body-heading">Store Location</h3>
                            <span class="footer__body-text">500 Terry Francois Street</span>
                            <span class="footer__body-text">San Francisco, CA 94158</span>
                            <span class="footer__body-text">info@mysite.com</span>
                            <span class="footer__body-text">123-456-7890</span>
                            <div class="footer__body-app">
                                <a href="" class="footer__body-link">
                                    <i class="footer__body-link fa-brands fa-facebook-f"></i>
                                </a>
                                <a href="" class="footer__body-link">
                                    <i class="footer__body-link fa-brands fa-instagram-square"></i>
                                </a>
                                <a href="" class="footer__body-link">
                                    <i class="footer__body-link fa-brands fa-twitter"></i>
                                </a>
                                <a href="" class="footer__body-link">
                                    <i class="footer__body-link fa-brands fa-youtube"></i>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col-l-3">
                        <div class="footer__body">
                            <h3 class="footer__body-heading">Shop</h3>
                            <span class="footer__body-text">Shop All</span>
                            <span class="footer__body-text">Computers</span>
                            <span class="footer__body-text">Drones & Cameras</span>
                            <span class="footer__body-text">Audio</span>
                            <span class="footer__body-text">Mobile</span>
                            <span class="footer__body-text">T.V & Home Cinema</span>
                            <span class="footer__body-text">Wearable Tech</span>
                            <span class="footer__body-text">Sale</span>
                        </div>
                    </div>
                    <div class="col-l-3">
                        <div class="footer__body">
                            <h3 class="footer__body-heading">Customer Support</h3>
                            <span class="footer__body-text">Contact Us</span>
                            <span class="footer__body-text">Help Center</span>
                            <span class="footer__body-text">About Us</span>
                            <span class="footer__body-text">Careers</span>
                        </div>
                    </div>
                    <div class="col-l-3">
                        <div class="footer__body">
                            <h3 class="footer__body-heading">Policy</h3>
                            <span class="footer__body-text">Shipping & Returns</span>
                            <span class="footer__body-text">Terms & Conditions</span>
                            <span class="footer__body-text">Payment Methods</span>
                            <span class="footer__body-text">FAQ</span>
                        </div>
                    </div>
                </div>

                
                <!-- Pay footer -->
                <div class="footer-pay">
                    <span class="footer-pay__text">We accept the following paying methods</span>
                    <div class="footer-pay__app">
                        <a href="" class="footer-pay__link">
                            <img src="https://static.wixstatic.com/media/84770f_27001c40036842889a78a72766ad4700~mv2.png/v1/fill/w_69,h_41,al_c,q_85,usm_0.66_1.00_0.01,enc_auto/Visa.png" alt="" class="footer-pay__link-icon">
                        </a>
                        <a href="" class="footer-pay__link">
                            <img src="https://static.wixstatic.com/media/c837a6_e8798fcfdaf144478a5c7da1ba28ff2c~mv2.png/v1/fill/w_69,h_43,al_c,q_85,usm_0.66_1.00_0.01,enc_auto/brand-mastercard%403x.png" alt="" class="footer-pay__link-icon">
                        </a>
                        <a href="" class="footer-pay__link">
                            <img src="https://static.wixstatic.com/media/c837a6_2bd3e20d1e214eccb5e106fc6d1f535d~mv2.png/v1/fill/w_69,h_36,al_c,q_85,usm_0.66_1.00_0.01,enc_auto/brand-amex%403x.png" alt="" class="footer-pay__link-icon">
                        </a>
                        <a href="" class="footer-pay__link">
                            <img src="https://static.wixstatic.com/media/c837a6_52115f99af28419d95a951f226e32e2b~mv2.png/v1/fill/w_69,h_43,al_c,q_85,usm_0.66_1.00_0.01,enc_auto/brand-chinaunionpay%403x.png" alt="" class="footer-pay__link-icon">
                        </a>
                        <a href="" class="footer-pay__link">
                            <img src="https://static.wixstatic.com/media/c837a6_9378fbd3ef8c470bb89aee12ecbd2209~mv2.png/v1/fill/w_69,h_43,al_c,q_85,usm_0.66_1.00_0.01,enc_auto/brand-jcb%403x.png" alt="" class="footer-pay__link-icon">
                        </a>
                        <a href="" class="footer-pay__link">
                            <img src="https://static.wixstatic.com/media/84770f_70555dcb450a415d80322cb8d7e82a33~mv2.png/v1/fill/w_65,h_48,al_c,q_85,usm_0.66_1.00_0.01,enc_auto/Diners.png" alt="" class="footer-pay__link-icon">
                        </a>
                        <a href="" class="footer-pay__link">
                            <img src="https://static.wixstatic.com/media/84770f_14f105815c3f47bf9001990706915501~mv2.png/v1/fill/w_69,h_44,al_c,q_85,usm_0.66_1.00_0.01,enc_auto/Discover.png" alt="" class="footer-pay__link-icon">
                        </a>
                        <a href="" class="footer-pay__link">
                            <img src="https://static.wixstatic.com/media/84770f_8445424a46ca49f39359bf19d4a3e537~mv2.png/v1/fill/w_69,h_48,al_c,q_85,usm_0.66_1.00_0.01,enc_auto/PayPal.png" alt="" class="footer-pay__link-icon">
                        </a>
                    </div>
                </div>
            </div>
        </footer>


        <!-- section TechShed -->
        <div class="techshed">
            <span class="techshed-text">Â© 2023 by TechShed. Proudly created with 
                <a href="https://manage.wix.com/account/sites" class="techshed-text__link">Wix.com</a>
            </span>
        </div>
    </div>


</body>
</html>