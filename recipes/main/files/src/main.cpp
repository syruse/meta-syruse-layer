#include <QGuiApplication>
#include <QQmlApplicationEngine>
#include <QDebug>

int main(int argc, char *argv[]) {
    QGuiApplication app(argc, argv);

    QQmlApplicationEngine m_engine;

    m_engine.load(QUrl("qrc:/main.qml"));
    if (m_engine.rootObjects().isEmpty()) {
        qCritical() << "syruse-layer failed";
        return -1;
    } else {
        qInfo() << "syruse-layer loaded";
    }

    return app.exec();
}

