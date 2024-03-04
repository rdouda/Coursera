# Use an official Node.js runtime as a base image
FROM node:hydrogen-slim
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
EXPOSE 3000
CMD ["npm", "start"]
