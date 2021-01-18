/* eslint-disable */
export default ( function() {

    function getParam(name) {
        name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
        var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
            results = regex.exec(location.search);
        return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
    }

    var controller, cursor, initScene, riggedHand, stats;

    window.scene = null;
    window.renderer = null;
    window.camera = null;

    initScene = function(element) {
        window.scene = new THREE.Scene();
        window.renderer = new THREE.WebGLRenderer({
            alpha: true
        });
        renderer.setClearAlpha(0);
        renderer.setSize(.95*window.innerWidth, .85*window.innerHeight);
        element.appendChild(renderer.domElement);
        window.camera = new THREE.PerspectiveCamera(50, window.innerWidth / window.innerHeight , 0.1, 2000);
        camera.position.fromArray([0, 320, 90]);
        camera.lookAt(new THREE.Vector3(0, -400, -450));
        scene.add(camera);
        window.addEventListener('resize', function() {
            camera.aspect = window.innerWidth / window.innerHeight;
            camera.updateProjectionMatrix();
            renderer.setSize(window.innerWidth, window.innerHeight);
            controls.handleResize();
            return renderer.render(scene, camera);
        }, false);
        return renderer.render(scene, camera);
    };

    // via Detector.js:
    var webglAvailable  = ( function () {
        try {
            var canvas = document.createElement( 'canvas' );            
            return !! window.WebGLRenderingContext && ( canvas.getContext( 'webgl' ) || canvas.getContext( 'experimental-webgl' ) ); 
        } catch( e ) {
            console.log("Error printing canvas: " + e);
            return false; 
        } 
    })();

    if (webglAvailable) {
        initScene(document.body);
    }
         
    if (getParam('screenPosition')) {
        cursor = document.createElement('div');
        cursor.style.width = '50px';
        cursor.style.height = '50px';
        cursor.style.position = 'absolute';
        cursor.style.zIndex = '10';
        cursor.style.opacity = '0.8';
        cursor.style.color = 'white';
        cursor.style.fontFamily = 'curior';
        cursor.style.textAlign = 'center';
        cursor.innerHTML = "&lt;div&gt;";
        document.body.appendChild(cursor);
        controller.on('frame', function(frame) {
        var hand, handMesh, screenPosition;
        if (hand = frame.hands[0]) {
            handMesh = frame.hands[0].data('riggedHand.mesh');
            screenPosition = handMesh.screenPosition(hand.fingers[1].tipPosition, camera);
            cursor.style.left = screenPosition.x;
            return cursor.style.bottom = screenPosition.y;
        }
        });
    }

    if (getParam('scenePosition')) {
        window.sphere = new THREE.Mesh(new THREE.SphereGeometry(1), new THREE.MeshBasicMaterial(0x0000ff));
        scene.add(sphere);
        controller.on('frame', function(frame) {
        var hand, handMesh;
        if (hand = frame.hands[0]) {
            handMesh = frame.hands[0].data('riggedHand.mesh');
            return handMesh.scenePosition(hand.indexFinger.tipPosition, sphere.position);
        }
        });
    } 

    if (getParam('boneHand')) {
        riggedHand = controller.plugins.riggedHand;
        controller.use('boneHand', {
        renderer: riggedHand.renderer,
        scene: riggedHand.parent,
        camera: riggedHand.camera,
        render: function() {}
        });
    }
    
    window.controller = controller = new Leap.Controller;

    controller.use('handHold').use('transform', {
        position: new THREE.Vector3(1, 0, 0)
        }).use('handEntry').use('screenPosition').use('riggedHand', {
        parent: scene,
        renderer: renderer,
        scale: getParam('scale'),
        positionScale: getParam('positionScale'),
        helper: true,
        offset: new THREE.Vector3(0, 0, 0),
        frameEventName: 'animationFrame',
        renderFn: function() {
            renderer.render(scene, camera);
        },
        materialOptions: {
            wireframe: getParam('wireframe'),
        },
        dotsMode: getParam('dots'),
        stats: stats,
        camera: camera,
        checkWebGL: true
    });    

    return controller;
})
/* eslint-enalbe */
