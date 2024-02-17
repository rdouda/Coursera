# Node.js and Express Introduction

This module provides an introduction to Node.js and Express, two essential technologies for building modern web applications. Whether you're a beginner or looking to enhance your skills, this guide will help you set up your development environment, install Node.js and NPM, and create your first Node.js application.

## Getting Started

### Prerequisites
- [Node.js](https://nodejs.org/) installed
- [NPM](https://www.npmjs.com/) (Node Package Manager) installed

# REST Architecture Overview

REST stands for Representational State Transfer, a term coined by Roy Fielding in 2000. It is an architecture style for designing loosely coupled applications over the network, often used in the development of web services.

REST does not enforce any rule regarding how it should be implemented at the lower level; it provides high-level design guidelines and leaves us to think of our own implementation.

[**Read more**](https://restfulapi.net/rest-architectural-constraints/#:~:text=REST%20stands%20for,our%20own%20implementation)

## HTTP Methods: GET, PUT, Delete, POST

HTTP defines a set of request methods to indicate the desired action to be performed for a given resource. Although they can also be nouns, these request methods are sometimes referred to as HTTP verbs. Each of them implements a different semantic, but some common features are shared by a group of them; for example, a request method can be safe, idempotent, or cacheable.

[**Read more**](https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods)

## RESTful APIs Usage for Web Building Web Application

A REST API is an API implementation that adheres to the REST architectural constraints. It acts as an interface, and communication between the client and the server happens over HTTP. A REST API takes advantage of HTTP methodologies to establish communication between the client and the server. REST also enables servers to cache the response, improving the application’s performance.

[**Read more**](https://www.educative.io/courses/web-application-software-architecture-101/qADAzX6yorR)

## Building a Simple RESTful API with Node.js and Express

REST APIs are often used to provide access to data stored in a database or to enable communication between different systems and applications.

For example, imagine you have a social media app that needs to fetch the latest posts from a server. You could build a REST API to handle this task, allowing the app to send a request to the API and receive a response with the latest posts in return. This way, the app can stay up-to-date with the latest content, and you can keep the data in a central location that can be accessed by multiple clients.

[**Read more**](https://levelup.gitconnected.com/creating-a-rest-api-with-node-js-and-express-a-step-by-step-guide-3bd7188fa219)
