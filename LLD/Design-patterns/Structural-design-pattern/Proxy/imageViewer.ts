import https from "https";
import fs from "fs";
import { exec } from "child_process";

class RealImage {
  url?: string;
  imageElt?: string;

  constructor(url: string) {
    this.url = url;
  }

  public async loadImage() {
    try {
      if (this.url) {
        const response = await fetch(this.url);
        this.imageElt = response.url;
        console.log('🚀 ~ Image loaded..')
      }
    } catch (error) {
      throw error;
    }
  }

  public render() {
    console.log(`🚀 ~ ${this.imageElt} is rendering...`);
    const fileName = "image.jpg";
    const file = fs.createWriteStream(fileName);
    if (this.imageElt) {
      https.get(this.imageElt, (response) => {
        response.pipe(file);
      });
    }

    const command = `open ${fileName}`;
    exec(command, (err) => {
      if (err) {
        console.error("🚀 ~ Failed to open image:", err);
      } else {
        console.log("🚀 ~ Image opened successfully!");
      }
    });
  }
}

class ImageProxy {
  private realImage?: RealImage;
  private url: string;

  constructor(imgUrl: string) {
    this.url = imgUrl;
  }

  public async loadImage() {
    if (!this.realImage) {
      this.realImage = new RealImage(this.url);
      await this.realImage.loadImage();
    }
  }

  public render() {
    if (this.realImage) {
      this.realImage.render();
    } else {
      console.log("Image not loaded yet.");
    }
  }
}

const proxy = new ImageProxy("https://loremflickr.com/320/240");
proxy.loadImage().then(() => {
  proxy.render();
});
