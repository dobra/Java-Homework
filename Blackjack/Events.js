var cards =
[
            "As Re",
            "As Ne",
            "As Tr",
            "As Ro",
            "2 Re",
            "2 Ne",
            "2 Tr",
            "2 Ro",
            "3 Re",
            "3 Ne",
            "3 Tr",
            "3 Ro",
            "4 Re",
            "4 Ne",
            "4 Tr",
            "4 Ro",
            "5 Re",
            "5 Ne",
            "5 Tr",
            "5 Ro",
            "6 Re",
            "6 Ne",
            "6 Tr",
            "6 Ro",
            "7 Re",
            "7 Ne",
            "7 Tr",
            "7 Ro",
            "8 Re",
            "8 Ne",
            "8 Tr",
            "8 Ro",
            "9 Re",
            "9 Ne",
            "9 Tr",
            "9 Ro",
            "10 Re",
            "10 Ne",
            "10 Tr",
            "10 Re",
            "J Re",
            "J Ne",
            "J Tr",
            "J Ro",
            "Q Re",
            "Q Ne",
            "Q Tr",
            "Q Ro",
            "K Re",
            "K Ne",
            "K Tr",
            "K Ro",

        ]
;

var cards_value =
        [
            1,1,1,1,
            2,2,2,2,
            3,3,3,3,
            4,4,4,4,
            5,5,5,5,
            6,6,6,6,
            7,7,7,7,
            8,8,8,8,
            9,9,9,9,
            10,10,10,10,
            10,10,10,10,
            10,10,10,10,
            10,10,10,10

        ];


var ai_cards = [0,0,0,0,0]
var ai_card_position = 0
var ai_cards_sum=0;
var ai_first_card;

var player_cards = [0,0,0,0,0]
var player_card_position = 0
var player_cards_sum=0;

var percentage=60;

var game_status=0;
var cards_length = 52;
var cards_position=0;

var player_points=0;
var ai_points=0;

function start_GAME()
{

//We start the game by initializing the deck
//The next for does just that.
    player_card_position = 0;
    ai_card_position = 0;
    game_status=0;
    teren.ai_Card1 = " ";
    teren.ai_Card2 = " ";
    teren.ai_Card3 = " ";
    teren.ai_Card4 = " ";
    teren.ai_Card5 = " ";

    teren.player_Card1 = " ";
    teren.player_Card2 = " ";
    teren.player_Card3 = " ";
    teren.player_Card4 = " ";
    teren.player_Card5 = " ";


//Afterwards we shuffle the deck
    if(cards_position == 0)
    {
     shuffleArray()
    }

//Followed by giving the player and the AI 2 cards->
//1'st and 3'rd one to the AI
//2'nd and 4'th one to the player
    ai_first_card=cards[cards_position];
    teren.ai_Card1 = "*"
    ai_cards[ai_card_position++]=cards_value[cards_position++];

    teren.player_Card1 = cards[cards_position];
    player_cards[player_card_position++]=cards_value[cards_position++];

    teren.ai_Card2 = cards[cards_position];
    ai_cards[ai_card_position++]=cards_value[cards_position++];

    teren.player_Card2 = cards[cards_position];
    player_cards[player_card_position++]=cards_value[cards_position++];

    cards_length-=4;
    teren.remainingCards=cards_length;

    /*for (var i = 0; i < 52; i++)
    {
        console.log(cards[i]+" - " + cards_value[i]);
    }*/
    player_cards_sum=0;
    for(var i=0;i<player_card_position;i++)
    {
        if(player_cards[i] == 1)
        {
            console.log("I am an ace:" + player_cards_sum)
            player_cards_sum+=11;
        }
        else
        {
            console.log("I am NOT an ace:" + player_cards_sum)
            player_cards_sum+=player_cards[i];
        }
    }
    teren.current_status=player_cards_sum


}

function player_draw_card()
{
    if(game_status==0)
    {
        switch(player_card_position)
        {
        case 2:
            teren.player_Card3 = cards[cards_position];
            player_cards[player_card_position++]=cards_value[cards_position++];
            teren.remainingCards=--cards_length;
        break;
        case 3:
            teren.player_Card4 = cards[cards_position];
            player_cards[player_card_position++]=cards_value[cards_position++];
            teren.remainingCards=--cards_length;
        break;
        case 4:
            teren.player_Card5= cards[cards_position];
            player_cards[player_card_position++]=cards_value[cards_position++];
            teren.remainingCards=--cards_length;
        break;
        }

        player_cards_sum=0;
       /* for(var i=0;i<player_card_position;i++)
        {
            player_cards_sum+=player_cards[i]
                console.log("Sum is:" + player_cards[i])
        }*/
        for(var i=0;i<player_card_position;i++)
        {
            if(player_cards[i] == 1)
            {

                player_cards_sum+=11;
            }
            else
            {
                player_cards_sum+=player_cards[i];
            }
        }

        if(player_cards_sum>21)
        {
            player_cards_sum=0;
            for(var i=0;i<player_card_position;i++)
            {
                   player_cards_sum+=player_cards[i];
            }
        }

        teren.current_status=player_cards_sum
        console.log("Sum is:" + player_cards_sum)

        if(player_cards_sum>21)
        {
            teren.current_status="Player>21"
            game_status=1;
            ai_points++;
            teren.ai_Score=ai_points;
        }
    }

}

function let_the_ai_draw()
{
    while(game_status==0)
    {
        ai_cards_sum=0;
        for(var i=0;i<ai_card_position;i++)
        {
            if(ai_cards[i] == 1)
            {
                ai_cards_sum+=11;
            }
            else
            {
                ai_cards_sum+=ai_cards[i];
            }
        }

        if(ai_cards_sum>21)
        {
            ai_cards_sum=0;
            for(var i=0;i<ai_card_position;i++)
            {
                   ai_cards_sum+=ai_cards[i];
            }
        }


        var good_cards_count=0;
        var choice_percentage=0;
        for(var i=cards_position;i<52;i++)
        {
            if((cards_value[i]+ai_cards_sum)<=21)
            {
              good_cards_count++;
            }

        }

        choice_percentage=((good_cards_count)/(52-cards_position))*100;
        console.log("Percentage:" + choice_percentage);

      if((ai_cards_sum>16)&&(choice_percentage<percentage))
      {
          game_status=1;
           console.log("Game finished with sum:" + ai_cards_sum);
      }
      else
      {
          switch(ai_card_position)
          {
          case 2:
              teren.ai_Card3 = cards[cards_position];
              ai_cards[ai_card_position++]=cards_value[cards_position++];
              teren.remainingCards=--cards_length;
          break;
          case 3:
              teren.ai_Card4 = cards[cards_position];
              ai_cards[ai_card_position++]=cards_value[cards_position++];
              teren.remainingCards=--cards_length;
          break;
          case 4:
              teren.ai_Card5= cards[cards_position];
              ai_cards[ai_card_position++]=cards_value[cards_position++];
              teren.remainingCards=--cards_length;
          break;
          }
      }


    }
}

function calculate_winer()
{
    if(ai_cards_sum>21)
    {
        teren.current_status="PLAY WIN!"
        player_points++;
        teren.player_Score=player_points;
    }
    else
    if(ai_cards_sum == player_cards_sum)
    {
        teren.current_status="AI WIN!"
        ai_points++;
        teren.ai_Score=ai_points;
    }
    else
    if(ai_cards_sum > player_cards_sum)
    {
        teren.current_status="AI WIN!"
        ai_points++;
        teren.ai_Score=ai_points;
    }
    else
    {
        teren.current_status="PLAY WIN!"
        player_points++;
        teren.player_Score=player_points;
    }
}

function stop_drawing()
{
    if(game_status == 0)
    {
        teren.ai_Card1=ai_first_card
        let_the_ai_draw();
        calculate_winer();
    }
}

function shuffleArray()
{
    for (var i = 52 - 1; i > 0; i--)
    {
        var j = Math.floor(Math.random() * (i + 1));
        var temp = cards[i];
        cards[i] = cards[j];
        cards[j] = temp;
        temp = cards_value[i];
        cards_value[i] = cards_value[j];
        cards_value[j] = temp;
    }
}
