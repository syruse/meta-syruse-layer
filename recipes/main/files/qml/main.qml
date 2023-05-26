import QtQuick 2.12
import QtQuick.Window 2.12

Window {
    width: 512
    height: 512
    visible: true
    title: qsTr("syruse-layer")

    /*Image {
        mipmap: true
        smooth: true
        fillMode: Image.Stretch
        anchors.fill: parent
        source: "qrc:/Water.jpg"
    }*/    
    Text {
        color: Qt.rgba(1, 1, 1, 1)
        font.pointSize: 24
        text: "Hello World"
        anchors.centerIn: parent
    }    
    Rectangle {
        anchors.fill: parent
        color: "transparent"
        radius: 8
        border.width: 4
        border.color: "red"
    }    
    MouseArea {
        anchors.fill: parent
        onClicked: {
            console.log("cell is no longer clickable ")
        }
    }
}
