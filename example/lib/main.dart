import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:amap_nav/amap_nav.dart';
import 'package:amap_nav/load.dart';
void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String _platformVersion = 'Unknown';

  bool flag = false;

  @override
  void initState() {
    super.initState();
    initPlatformState();
  }


  Future<void> initPlatformState() async {
    String platformVersion;
    // Platform messages may fail, so we use a try/catch PlatformException.
    // We also handle the message potentially returning null.
    try {
      platformVersion =
          await AmapNav.platformVersion ?? 'Unknown platform version';
    } on PlatformException {
      platformVersion = 'Failed to get platform version.';
    }


    if (!mounted) return;

    setState(() {
      _platformVersion = platformVersion;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('导航'),
        ),
        body: Container(
          child: Stack(
            children: [
               TextButton(
                  child: Text('${_platformVersion}'),
                  onPressed:(() {

                  })
              ),
              Container(
                width: 400,
                height: 400,
                child: const navWidget(),
              ),
              Positioned(
                bottom: 0,
                  top: 40,
                  child:
                Container(
                  width: 400,
                  height: 400,
                  color: Colors.yellowAccent,
                )
              )

            ],
          ),
        )
      ),
    );
  }
}
