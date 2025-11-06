# Stage 1: Prepare the frontend assets
FROM node:20-alpine AS build
WORKDIR /app
COPY package.json .
COPY package-lock.json .
RUN npm install
COPY www ./www

# Stage 2: Serve with Nginx
FROM nginx:stable-alpine
COPY --from=build /app/www /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
