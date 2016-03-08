#!/bin/sh

echo "Building frontend..."
(cd front && npm install && grunt build) || exit 1

echo "Copying frontend resources..."
mkdir -p back/src/main/resources/public || exit 1
cp -R front/dist/* back/src/main/resources/public || exit 1

echo "Building backend..."
(cd back && mvn -q clean install) || exit 1

echo "Done."
