import QtQuick 2.3
import "./Events.js" as BJFunctions


Rectangle {
    id:teren

    property string ai_Card1:qsTr(" ")
    property string ai_Card2:qsTr(" ")
    property string ai_Card3:qsTr(" ")
    property string ai_Card4:qsTr(" ")
    property string ai_Card5:qsTr(" ")

    property string player_Card1:qsTr(" ")
    property string player_Card2:qsTr(" ")
    property string player_Card3:qsTr(" ")
    property string player_Card4:qsTr(" ")
    property string player_Card5:qsTr(" ")

    property string ai_Score:qsTr("0")
    property string player_Score:qsTr("0")

    property string remainingCards:qsTr("52")
    property string current_status:qsTr("0")

    width: 360
    height: 360

    Item{
        id: aiCarti
        Text {
            id: aiCard5
            x: 539
            y: 206
            width: 58
            height: 30
            text: ai_Card5
            font.strikeout: false
            style: Text.Raised
            font.pixelSize: 20
        }

        Text {
            id: aiCard4
            x: 423
            y: 206
            width: 58
            height: 30
            text: ai_Card4
            font.strikeout: false
            style: Text.Raised
            font.pixelSize: 20
        }

        Text {
            id: aiCard3
            x: 315
            y: 206
            width: 58
            height: 30
            text: ai_Card3
            font.strikeout: false
            style: Text.Raised
            font.pixelSize: 20
        }

        Text {
            id: aiCard2
            x: 204
            y: 206
            width: 58
            height: 30
            text: ai_Card2
            font.strikeout: false
            style: Text.Raised
            font.pixelSize: 20
        }


        Text {
            id: aiCard1
            x: 97
            y: 206
            width: 58
            height: 30
            text: ai_Card1
            font.strikeout: false
            style: Text.Raised
            font.pixelSize: 20
        }
    }

    Item{
        id: playerCarti
        Text {
            id: playerCard5
            x: 516
            y: 987
            width: 58
            height: 30
            text: player_Card5
            font.strikeout: false
            style: Text.Raised
            font.pixelSize: 20
        }

        Text {
            id: playerCard4
            x: 409
            y: 987
            width: 58
            height: 30
            text: player_Card4
            font.strikeout: false
            style: Text.Raised
            font.pixelSize: 20
        }

        Text {
            id: playerCard3
            x: 297
            y: 987
            width: 58
            height: 30
            text: player_Card3
            font.strikeout: false
            style: Text.Raised
            font.pixelSize: 20
        }

        Text {
            id: playerCard2
            x: 190
            y: 987
            width: 58
            height: 30
            text: player_Card2
            font.strikeout: false
            style: Text.Raised
            font.pixelSize: 20
        }


        Text {
            id: playerCard1
            x: 83
            y: 987
            width: 58
            height: 30
            text: player_Card1
            font.strikeout: false
            style: Text.Raised
            font.pixelSize: 20
        }
    }
Text {
            id: nrOfCards
            x: 597
            y: 603
            text: remainingCards
            font.pixelSize: 12
        }

Image {
            id: cardBack
            x: 548
            y: 381
            width: 139
            height: 204
            source: "./CardBack.jpeg"
        }

Text {
    id: aiScore
    x: 286
    y: 460
    text: ai_Score
    font.pixelSize: 30
}

Text {
    id: playerScore
    x: 286
    y: 730
    text: player_Score
    font.pixelSize: 30
}

Rectangle {
    id: draw
    x: 538
    y: 638
    width: 159
    height: 70
    color: "#15b866"
    radius: 23
    border.width: 2

    Text {
        id: drawACard
        text: qsTr("Draw A Card ")
        anchors.rightMargin: 0
        anchors.bottomMargin: 0
        anchors.leftMargin: 0
        anchors.topMargin: 0
        anchors.fill: parent
        verticalAlignment: Text.AlignVCenter
        horizontalAlignment: Text.AlignHCenter
        font.pixelSize: 12
    }

    MouseArea {
        id: drawMouseArea
        anchors.fill: parent
        //onClicked:
    }
    Component.onCompleted:{ drawMouseArea.clicked.connect(BJFunctions.player_draw_card)}
}

Rectangle {
    id: stopDraw
    x: 538
    y: 730
    width: 159
    height: 70
    color: "#15b866"
    radius: 23
    Text {
        id: stopCardDraw
        text: qsTr("StopDrawing")
        anchors.topMargin: 0
        anchors.bottomMargin: 0
        anchors.fill: parent
        font.pixelSize: 12
        horizontalAlignment: Text.AlignHCenter
        verticalAlignment: Text.AlignVCenter
        anchors.leftMargin: 0
        anchors.rightMargin: 0
    }

    MouseArea {
        id: stopDrawMouseArea
        anchors.fill: parent
        //onClicked:stop_drawing
        Component.onCompleted:{ stopDrawMouseArea.clicked.connect(BJFunctions.stop_drawing)}
    }

    border.width: 2
}

Rectangle {
    id: startGame
    x: 263
    y: 548
    width: 177
    height: 98
    color: "#15b866"
    radius: 23
    Text {
        id: startGameText
        text: qsTr("START")
        font.bold: true
        anchors.topMargin: 0
        anchors.bottomMargin: 0
        anchors.fill: parent
        font.pixelSize: 20
        horizontalAlignment: Text.AlignHCenter
        verticalAlignment: Text.AlignVCenter
        anchors.leftMargin: 0
        anchors.rightMargin: 0
    }

    MouseArea {
        id: startGameMouseArea
        anchors.fill: parent
        //onPressed: BJFunctions.start_GAME()
    }
    Component.onCompleted:{ startGameMouseArea.clicked.connect(BJFunctions.start_GAME)}
    border.width: 2
}

Text {
    id: game_status_text
    x: 64
    y: 577
    width: 131
    height: 56
    text: current_status
    font.bold: true
    font.pixelSize: 20
}
}
