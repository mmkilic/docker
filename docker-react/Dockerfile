# build stage
FROM node:lts-alpine as builder
WORKDIR /app
COPY package*.json ./
RUN npm install --force
RUN npm i --force ajv@latest
COPY . .
RUN npm run build

# production stage
FROM nginx:1.25.5
COPY --from=builder /app/build /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
