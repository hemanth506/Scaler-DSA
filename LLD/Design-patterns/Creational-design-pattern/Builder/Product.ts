enum ProductType {
  T_Shirts = "T_Shirts",
  Jean = "Jean",
  Shirt = "Shirt",
  Saree = "Saree",
  Crop_Top = "Crop_Top",
}

enum ColorType {
  Red = "Red",
  Blue = "Blue",
  Green = "Green",
  Yellow = "Yellow",
  Black = "Black",
}

enum sizeType {
  XS = "XS",
  S = "S",
  M = "M",
  L = "L",
  XL = "XL",
  XXL = "XXL",
}

class Product {
  private product?: ProductType;
  private size?: sizeType;
  private color?: ColorType;
  private price?: number;
  private brand?: string;
  private discount?: number;

  constructor(builder: ProductBuilder) {
    this.brand = builder.getBrand();
    this.color = builder.getColor();
    this.discount = builder.getDiscountValue();
    this.price = builder.getPrice();
    this.product = builder.getProductType();
    this.size = builder.getSize();
  }

  public static createBuilder(): ProductBuilder {
    return new ProductBuilder();
  }
}

class ProductBuilder {
  private product?: ProductType;
  private size?: sizeType;
  private color?: ColorType;
  private price?: number;
  private brand?: string;
  private discount?: number;

  public setProduct(product: ProductType): this {
    this.product = product;
    return this;
  }

  public setSize(size: sizeType): this {
    this.size = size;
    return this;
  }

  public setColor(color: ColorType): this {
    this.color = color;
    return this;
  }

  public setPrice(price: number): this {
    this.price = price;
    return this;
  }

  public setBrand(brand: string): this {
    this.brand = brand;
    return this;
  }

  public setDiscount(discount: number): this {
    this.discount = discount;
    return this;
  }

  private validate() {
    return true;
  }

  public build(): Product | Error {
    if (!this.validate()) {
      return new Error("Error in validation");
    }
    // console.log(":) ===== ", this);
    return new Product(this);
  }

  public getProductType = () => this.product;
  public getDiscountValue = () => this.discount;
  public getBrand = () => this.brand;
  public getPrice = () => this.price;
  public getSize = () => this.size;
  public getColor = () => this.color;
}

const product1 = Product.createBuilder()
  .setBrand("Levis")
  .setColor(ColorType.Black)
  .setDiscount(10)
  .setPrice(850)
  .setProduct(ProductType.Jean)
  .setSize(sizeType.M)
  .build();

console.log(product1);

const product2 = Product.createBuilder()
  .setBrand("Allen SOly")
  .setColor(ColorType.Blue)
  .setDiscount(8)
  .setPrice(1050)
  .setProduct(ProductType.Shirt)
  .setSize(sizeType.L)
  .build();

console.log(product2);
