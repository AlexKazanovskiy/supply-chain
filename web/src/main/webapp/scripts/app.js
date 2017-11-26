define.amd.dust = true;

requirejs.config({
    baseUrl: '../scripts/',
    map: {
        '*': {
            'css': '../scripts/vendors/require-css/css'
        }
    },
    paths: {
        styles: '../css',
        lib: '../scripts/lib',
        vendors: '../scripts/vendors',
        underscore: '../scripts/vendors/underscore/underscore',
        backbone: '../scripts/vendors/backbone/backbone',
        jquery: '../scripts/vendors/jquery/dist/jquery',
        dust: '../scripts/vendors/dustjs-linkedin/dist/dust-full',
        text: '../scripts/vendors/requirejs-text/text',
        bootstrap: '../scripts/vendors/bootstrap/dist/js/bootstrap',
        bootcss: '../scripts/vendors/bootstrap/dist/css/bootstrap',
        main: '../scripts',
        config: '../scripts/config',
        vectormaplib: '../scripts/jquery-jvectormap-1.2.2.min',
        vectormap: '../scripts/vendors/jvectormap/jquery-jvectormap',
        vectormapcss: '../scripts/vendors/jvectormap/jvectormap'
    }
});
