set -e

npm run build

cd dist

git init
git add -A
git commit -m 'Novo Deploy'
git push -f https://github.com/ThiefBrRj/ProjetoImobiliaria_FrontEnd master:gh-pages

cd -