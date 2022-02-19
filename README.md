# `oz` with `webpack` Failure Reproduction

Run these commands to reproduce the failure:

```
npm install
npx shadow-cljs watch app
npx webpack --entry ./target/index.js --output-path public/js/libs.js
npx shadow-cljs watch app
```

Open the app in your browser and look at the chrome console.

Comment out `:js-options` key in `shadow-cljs.edn` and run without the webpack
command to see the page work fine when using pure shadow-cljs.  You might also
need to comment out the `script src="/js/libs.js/main.js"` tag in index.html.
