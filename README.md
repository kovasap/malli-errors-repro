# `oz` with `webpack` Failure Reproduction

Run these commands to reproduce the failure:

```
npm install
npx shadow-cljs watch app
npx webpack --entry ./target/index.js --output-path public/js/libs.js
npx shadow-cljs watch app
```

Open the app in your browser and look at the chrome console.
