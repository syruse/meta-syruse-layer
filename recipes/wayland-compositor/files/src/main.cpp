#include <QGuiApplication>
#include <QQmlApplicationEngine>
#include <QDebug>

int main(int argc, char *argv[]) {
    // ShareOpenGLContexts is needed for using the threaded renderer
    // EGLStreams for multiple monitors
    QCoreApplication::setAttribute(Qt::AA_ShareOpenGLContexts, true);
    
    QGuiApplication app(argc, argv);

    QQmlApplicationEngine m_engine;

    m_engine.load(QUrl("qrc:/main.qml"));
    if (m_engine.rootObjects().isEmpty()) {
        qCritical() << "syruse-layer-compositor failed";
        return -1;
    } else {
        qInfo() << "syruse-layer-compositor loaded";
    }

    return app.exec();
}

