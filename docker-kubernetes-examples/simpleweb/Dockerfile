# Specify the base image.
FROM node:alpine

# we have to specify the working dir - we cannot put all in the project root directory.
WORKDIR /usr/app
# this is to copy only the json file to the container so that we can run npm install.
#COPY ./package.json ./
COPY ./ ./

# specify the dependencies
RUN npm install

# this is to copy all the files from current direcoty in the file system to 
# to copy in the container
#COPY ./ ./


# specify the commands to run 
CMD ["npm","start"]
