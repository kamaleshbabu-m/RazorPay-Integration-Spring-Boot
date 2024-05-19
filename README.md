# Razorpay Integration with Spring Boot

This project demonstrates the integration of Razorpay payment gateway with a Spring Boot application. The project includes functionalities to create orders, generate "Pay Now" buttons, and generate payment links.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
  - [Create Order](#create-order)
  - [Generate Payment Link](#generate-payment-link)
- [Endpoints](#endpoints)
- [License](#license)

## Prerequisites
- Java 11 or later
- Maven
- Razorpay API key and secret

## Installation
1. Clone the repository:
    ```bash
    git clone https://github.com/your-username/razorpay-spring-boot-integration.git
    cd razorpay-spring-boot-integration
    ```

2. Build the project:
    ```bash
    mvn clean install
    ```

3. Run the application:
    ```bash
    mvn spring-boot:run
    ```

## Configuration
1. Add your Razorpay API credentials in `application.properties`:
    ```properties
    razorpay.key_id=your_key_id
    razorpay.key_secret=your_key_secret
    ```

## Usage

### Create Order
To create an order, you can use the following endpoint:

- **Endpoint:** `/createorder`
- **Method:** `GET`
- **Request Body:**
    ```json
    {
      "amount": 50000,
      "currency": "INR",
      "receipt": "receipt#1",
      "payment_capture": 1
    }
    ```
- **Response:**
    ```json
    {
      "id": "order_9A33XWu170gUtm",
      "entity": "order",
      "amount": 50000,
      "currency": "INR",
      "receipt": "receipt#1",
      "status": "created",
      ...
    }
    ```

### Generate Payment Link
To generate a payment link, use the following endpoint:

- **Endpoint:** `/createpaymentlink`
- **Method:** `POST`
- **Request Body:**
    ```json
    {
      "amount": 30000,
      "currency": "INR",
      "accept_partial": true,
      "first_min_partial_amount": 1000,
      "reference_id": "TS1994",
      "description": "Payment for policy no #23456",
      "customer": {
        "name": "Kamaleshbabu M",
        "contact": "+919884406598",
        "email": "kamaleshbabu084@gmail.com"
      },
      "notify": {
        "sms": true,
        "email": true
      },
      "reminder_enable": true,
      "notes": {
        "policy_name": "Jeevan Bima"
      },
      "callback_url": "https://example-callback-url.com/",
      "callback_method": "get"
    }
    ```
- **Response:**
    ```json
    {
      "id": "plink_Fzj6mLndB6jTeh",
      "entity": "payment_link",
      "amount": 30000,
      "currency": "INR",
      ...
    }
    ```

## Endpoints

- `GET /createorder` - Creates an order with Razorpay.
- `POST /createpaymentlink` - Generates a payment link.
- `GET /` - Home endpoint to check if the service is running.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
