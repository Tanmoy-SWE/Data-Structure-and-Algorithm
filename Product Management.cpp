#include <iostream>
#include <cstring>
using namespace std;


class Product{
public :
    /*Defining all the methods and constructors in
      the the public scope of the class Product*/
    Product();
    Product(const char *ch, const char *name, float prc, int qty);
    void printProduct();
    void setProductCode(const char *ch);
    void setProductName(const char *name);
    void setProductPrice(float prc);
    void setProductQuantity(float qty);
    float getProductPrice();
    int getProductQuantity();
    int fillProductOrder(int qty);

    /*Defining all the variables and arrays of characters
     * in the private scope of the class Product*/
private:
    char idcode[15];
    char productName[50];
    float price;
    int quantity;
};

//setter method to copy string to Product ID
void Product::setProductCode(const char ch[15]){
    int i;
    strcpy(idcode,ch);
}
//setter method to set price of the product
void Product::setProductPrice(float prc){
    price = prc;
}
//setter method to set value of quantity of the product
void Product::setProductQuantity(float qty){
    quantity = qty;
}

//setter method to copy name to productName
void Product::setProductName(const char name[50]){
    int i;
    strcpy(productName,name);
}
//Getter method to get price
float Product::getProductPrice() {
    return price;
}
//Getter method to get quantity
int Product::getProductQuantity() {
    return quantity;
}
//Default constructor
Product::Product(){
    idcode[0]='\0';
    productName[0]='\0';
    price = 0.00;
    quantity = 0;
}

//User defined constructor.
Product::Product(const char ch[15], const char name[50], float prc, int qty){
    int i;
    strcpy(idcode,ch);
    strcpy(productName,name);
    if(prc>=0) {
        price = prc;
    }
    else{
        price = 0;
    }
    if(qty>=0) {
        quantity = qty;
    }
    else{
        quantity = 0;
    }

}
//method to print the different values of the product
void Product::printProduct(){

    int i;
    for(i=0; i< strlen(idcode); i++){
        cout << idcode[i];
    }
    for(i=0; i< 13-strlen(idcode); i++){
        cout << " ";
    }

    for(i=0; i< strlen(productName); i++){
        cout << productName[i];
    }
    for(i=0; i< 48-strlen(productName); i++){
        cout << " ";
    }
    cout << price << "    " << quantity << endl;
}

//Returns the shipped products and calculates the present quantity of the products
int Product::fillProductOrder(int qty) {
    if(qty<0){
        qty = 0;
    }
    else if(qty<=quantity && qty>=0){
        quantity = quantity-qty;
    }
    else{
        qty = quantity;
        quantity = 0;
    }
    return qty;
}


int main(){

    //Creating objects for products
    Product p1;
    Product p2("22222222222","Virtual Education Pack",0.99,31);
    Product p3("33333333333", "Dehydrated Water Bed", -12.99, -6);
    cout << "***** The 3 products *****" <<endl;
    //printing the values of the object by calling printProduct method
    cout << "Product 1" << endl;
    p1.printProduct();
    cout << "Product 2" << endl;
    p2.printProduct();
    cout << endl;
    cout << "Product 3" << endl;
    p3.printProduct();
    p1 = *new Product("11111111111","Flowbee Pet Groomer",339.99,28);
    cout << endl << "***** Product 1 after using the set methods *****" << endl;
    p1.printProduct();
    cout << endl << "***** Product 2 and 3s price and quantity *****" << endl;
    cout << "Product 2 Price: $" << p2.getProductPrice() << "    ";
    cout << "Quantity in Stock: " << p2.getProductQuantity() << endl;
    cout << "Product 3 Price: $" << p3.getProductPrice() << "    ";
    cout << "Quantity in Stock: " << p3.getProductQuantity() << endl;
    cout << "***** Order a negative number of Product 1s *****" << endl;
    int shipped = p1.fillProductOrder(-5);
    float total = shipped*p1.getProductPrice();
    p1.printProduct();
    cout << "Shipped: " << shipped;
    cout << "    "<< "Order Total: $" << total<< endl;
    p1.printProduct();
    cout << endl << "***** Order 12 Product 1s *****" << endl;
    p1.printProduct();
    shipped = p1.fillProductOrder(12);
    total = shipped*p1.getProductPrice();
    cout << "Shipped: " << shipped;
    cout << "    "<< "Order Total: $" << total<< endl;
    p1.printProduct();
    cout << endl << "***** Order 4 Product 2s *****" << endl;
    p2.printProduct();
    shipped = p2.fillProductOrder(4);
    total = shipped*p2.getProductPrice();
    cout << "Shipped: " << shipped;
    cout << "    "<< "Order Total: $" << total<< endl;
    p2.printProduct();
    cout << endl << "***** Order 45 Product 2s *****" << endl;
    p2.printProduct();
    shipped = p2.fillProductOrder(45);
    total = shipped*p2.getProductPrice();
    cout << "Shipped: " << shipped;
    cout << "    "<< "Order Total: $" << total<< endl;
    p2.printProduct();


}
