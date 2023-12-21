# Image Encryption Using AES Algorithm

## Overview

This Java project demonstrates image encryption using the AES algorithm in CBC mode with Initialization Vectors (IVs). The project involves loading an image, encrypting it, and then decrypting it using a randomly generated IV.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Project Structure](#project-structure)


## Prerequisites

- Java Development Kit (JDK) installed (version 8 or later)
- Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files installed
## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/Akshat0404/AES-Image-Encryptor.git
  Open the project in your preferred Java Integrated Development Environment (IDE).
  
  Build and run the ImageEncryptionApp.java class.
  
## Usage

  Replace the input.jpg file in the project directory with your own image file.
  Run the ImageEncryptionApp to perform image encryption and decryption.
  The encrypted image will be saved as encrypted.jpg, and the decrypted image will be saved as decrypted.jpg.

## Project Structure

  ImageEncryptionApp.java: Main class for running image encryption and decryption.
  ImageUtils.java: Utility class for image handling.
  input.jpg: Sample input image (replace with your own image).
  iv.bin: File containing the Initialization Vector (IV) used for encryption.
  encrypted.jpg: Encrypted image file.
  decrypted.jpg: Decrypted image file.
  README.md: Project documentation.
