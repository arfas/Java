var express = require('express');
var router = express.Router();
var Item = require('../models/Item');

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Welcome to CS557', units: '3', schedule: 'Saturday' });
});

/* GET order page. */
router.get('/order', function(req, res, next) {
  res.render('orderform', { title: 'Order Page'});
});

/* POST order page. */
router.post('/order', function(req, res, next) {
    //save the order item to the shopping cart
    req.session.cart.push(
            new Item(req.body.itemName, req.body.itemQty));
    console.log(req.session.cart);
    
  res.render('thankyou', { 
      title: 'Thank You', 
      message: 'Thank you for your order', 
      itemName: req.body.itemName, 
      itemQty: req.body.itemQty});
});


/* Update cart page */
router.post('/cart',function(req,res,next){
    var it=req.body.itemName;
    var q=req.body.itemQty;
    var msg="";
    
    //delete item
                if (req.body.submit == 'Delete') {

                    req.session.cart = req.session.cart.filter(function (el) {

                        return el.itemName !== it;
                    });
                    console.log(req.session.cart);
                    msg=it+" is Deleted";

                }
                
     //edit item
                if (req.body.submit == 'Update') {
            
                    console.log(req.session.cart);
                               req.session.cart.forEach(function (arrayElem){ 
                                   if(arrayElem.itemName==it){
                                       arrayElem.itemQty=q;
                                         console.log(it);
                                     }
                        });
                        msg=it+" is Updated";
                }
                if(req.session.cart.length==0){
                    
                    res.redirect('/order');
                }
                
                
                
    
    res.render('cart',{
        title: 'Cart Page',
        msg : msg,
        cart: req.session.cart
    });
});

/* GET cart page */
router.get('/cart',function(req,res,next){
    res.render('cart',{
        title: 'Cart Page',
        cart: req.session.cart
    });
});


module.exports = router;
