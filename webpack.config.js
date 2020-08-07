const VueLoader = require('vue-loader/lib/plugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const path = require('path');
const webpack = require('webpack');
const fs = require('fs');

module.exports = {
  entry: './src/app.js',
  mode: "production",
  output: {
    path: path.resolve(__dirname, 'build'),
    filename: './bundle.js'
  },
  module: {
    rules: [
      {
        test: /\.vue$/,
        loader: ['vue-loader']
      },
      {
        test: /\.js$/,
        exclude: /(node_modules)/,
        use: {
          loader: 'babel-loader',
          options: {
            presets: ['@babel/preset-env']
          }
        }
      },
      {
        test: /\.(css|scss)$/,
        use: [
          'vue-style-loader',
          'css-loader',
          'sass-loader'
        ]
      },
      {
        test: /\.(woff(2)?|ttf|eot|svg|png)(\?v=\d+\.\d+\.\d+)?$/,
        use: [{
            loader: 'file-loader',
            options: {
                name: '[name].[ext]',
                outputPath: 'fonts/',
                publicPath: '/build/fonts'
            }
        }]
      }
    ]
  },
  resolve: {
    alias: {
      vue: "vue/dist/vue.js",
      // styles: './src/scss/',
      jquery: "jquery/src/jquery"
    }
  },
  devServer: {
    host: '0.0.0.0',
    port: 8000,
    public: '0.0.0.0:8000',
    historyApiFallback: {
      index: 'http://localhost:8000/index.html'
    },
    proxy: {
      '/': {
        target: 'http://localhost:8500/'
      }
    }
  },
  plugins: [
    new VueLoader(),
    new webpack.ProvidePlugin({
        '$': 'jquery'
    }),
    new HtmlWebpackPlugin({
      template: "./index.html"
    })
  ]
};
