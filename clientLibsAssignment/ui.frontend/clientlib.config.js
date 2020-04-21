module.exports = {
    // default working directory (can be changed per 'cwd' in every asset option)
    context: __dirname,

    // path to the clientlib root folder (output)
    clientLibRoot: "./../ui.apps/src/main/content/jcr_root/apps/clientLibsAssignment/clientlibs",

    libs: [
        {
            name: "clientlib-dependencies",
            allowProxy: true,
            categories: ["clientLibsAssignment.dependencies"],
            serializationFormat: "xml",
            cssProcessor : ["default:none", "min:none"],
            jsProcessor: ["default:none", "min:none"],
            assets: {
                js: [
                    "dist/clientlib-dependencies/*.js",
                ],
                css: [
                    "dist/clientlib-dependencies/*.css"
                ]
            }
        },
        {
            name: "clientlib-site",
            allowProxy: true,
            categories: ["clientLibsAssignment.site"],
            dependencies: ["clientLibsAssignment.dependencies"],
            serializationFormat: "xml",
            cssProcessor : ["default:none", "min:none"],
            jsProcessor: ["default:none", "min:none"],
            assets: {
                js: [
                    "dist/clientlib-site/*.js",
                ],
                css: [
                    "dist/clientlib-site/*.css"
                ]
            }
        }
    ]
};