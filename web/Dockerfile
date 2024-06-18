# Usar una imagen base de nginx
FROM nginx:alpine

# Copiar la configuración de nginx al contenedor
COPY nginx.conf /etc/nginx/nginx.conf

# Copiar los archivos de la aplicación al directorio web de nginx
COPY www /usr/share/nginx/html

# Exponer el puerto 80
EXPOSE 80
