# Usa la imagen base de Nginx
FROM nginx:alpine

# Elimina cualquier configuración existente de Nginx
RUN rm -rf /usr/share/nginx/html/*

# Copia los archivos index.html y style.css a la carpeta de Nginx
COPY index.html /usr/share/nginx/html/
COPY style.css /usr/share/nginx/html/
COPY img /usr/share/nginx/html/img

# Exponer el puerto 80 para que Nginx pueda recibir solicitudes HTTP
EXPOSE 80

# Comando para iniciar Nginx en primer plano cuando se ejecute el contenedor
CMD ["nginx", "-g", "daemon off;"]
