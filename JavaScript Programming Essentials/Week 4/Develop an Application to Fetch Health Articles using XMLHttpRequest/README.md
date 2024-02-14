In a local development environment, when you are accessing files using the file:// protocol, the Same Origin Policy is applied strictly, and you may encounter these issues. To resolve this, consider using a local server or a development server to serve your files.

You can use Node.js:

    Node.js with http-server:
        Install Node.js if you haven't already.
        Install http-server globally by running: npm install -g http-server.
        Navigate to your project directory in the terminal.
        Run http-server by typing `npx http-server`
        Access your project using http://localhost:8080 or another port specified in the console.

By using a local server, you should be able to overcome the Same Origin Policy restriction during development.