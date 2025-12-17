import https from "https";
import fs from "fs";
import { exec } from "child_process";

interface ImageProcessor {
  loadImage: () => Promise<void>
  render: () => void
}

class RealImageProcessor implements ImageProcessor {
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

class ImageProcessorProxy implements ImageProcessor {
  private realImage?: RealImageProcessor;
  private url: string;

  constructor(imgUrl: string) {
    this.url = imgUrl;
  }

  public async loadImage() {
    if (!this.realImage) {
      this.realImage = new RealImageProcessor(this.url);
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

const proxy = new ImageProcessorProxy("https://loremflickr.com/320/240");
proxy.loadImage().then(() => {
  proxy.render();
});
