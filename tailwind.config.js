/** @type {import('tailwindcss').Config} */
module.exports = {
    mode: process.env.NODE_ENV ? 'jit' : undefined,
    content: [
        './src/**/*.html',
        './src/**/*.vue',
        './src/**/*.jsx',
        './src/main/resources/templates/**/*.html',
        './src/main/resources/static/js/**/*.js',
    ],
    theme: {
        extend: {},
    },
    plugins: [],
};