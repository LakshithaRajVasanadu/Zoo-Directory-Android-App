package com.homework2.lakshitha.zoodirectory;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.app.AlertDialog;
import android.content.DialogInterface;

import java.util.ArrayList;
import java.util.List;

// App works best with Nexus 5

public class ZooListMainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ListView listView = (ListView) findViewById(R.id.list_view);
        final List<Animal> animals = new ArrayList<>();
        this.populateData(animals);

        listView.setAdapter(new ListAdapter(this, R.layout.list_row, animals));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == animals.size() - 1) {
                    final Animal lastAnimal = animals.get(position);
                    AlertDialog.Builder builder = new AlertDialog.Builder(ZooListMainActivity.this);
                    builder.setMessage("This animal is very scary! Do you still want to proceed ?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(getBaseContext(), DetailsActivity.class);
                                    intent.putExtra("animal", lastAnimal);
                                    if (intent != null)
                                        startActivity(intent);
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // Do nothing
                                }
                            });
                    builder.create().show();


                } else {
                    Intent intent = new Intent(getBaseContext(), DetailsActivity.class);
                    intent.putExtra("animal", animals.get(position));
                    if (intent != null)
                        startActivity(intent);
                }

            }
        });

    }

    // Add data for animals
    private void populateData(List<Animal> animals) {
        Animal animal = new Animal("Grizzly Bear", "Ursus arctos", "grizzlyBear.jpg");
        animal.setFullSizeImageFileName("grizzlyBearFullSize.jpg");
        animal.setDescription("The grizzly bear is any North American morphological form or subspecies of brown bear."
                + "The grizzly bear is the California state mammal and the symbol on the California state flag."
                + "They're found in high mountain wooded areas, tundra and alpine meadows in Alaska, Western Canada, Idaho, Montana, Washington and Wyoming. "
                + "Their pelt shows a variety of colors from blond, brown, black or a combination of these. The large shoulder hump provides the muscle power to the forelimbs to dig winter dens. "
                + "They have been classified as a threatened species in the United States since 1975.");
        animals.add(animal);

        animal = new Animal("Bald Eagle", "Haliaeetus leucocephalus", "baldEagle.jpg");
        animal.setFullSizeImageFileName("baldEagleFullSize.jpg");
        animal.setDescription("The bald eagle is a bird of prey found in North America."
                + "It is found near large bodies of open water with an abundant food supply and old-growth trees for nesting."
                + "The bald eagle is an opportunistic feeder which subsists mainly on fish, which it swoops down and snatches from the water with its talons."
                + "It builds the largest nest of any North American bird and the largest tree nests ever recorded for any animal species."
                + "Bald eagles are not actually bald; the name derives from an older meaning of white headed.");
        animals.add(animal);

        animal = new Animal("Anise Swallowtail Caterpillar", "Papilio zelicaon", "caterpillar.jpg");
        animal.setFullSizeImageFileName("caterpillarFullSize.jpg");
        animal.setDescription("When this caterpillar turns into a butterfly, they only take one big flight in April-July."
                + "The caterpillar grows to around 5 cm in length before forming a chrysalis, which is brown or green and about 3 cm long."
                + "Often found in Western North America in proximity of foodplant; hilltops on the higher peaks, and gardens."
                + "Its major food plants are members of the carrot family, Apiaceae, (including fennel), and also some members of the citrus family, Rutaceae."
                + "These caterpillars are common and are not endangered.");
        animals.add(animal);

        animal = new Animal("Koala", "Phascolarctus cinereus adustus", "koala.jpg");
        animal.setFullSizeImageFileName("koalaFullSize.jpg");
        animal.setDescription("Koalas are marsupials – pouched animals – 25 to 32 inches in length, and weighing between 9 and 30 pounds (northern koalas are smaller than southern koalas)."
                + "Koalas live exclusively in eucalyptus forests in eastern Australia, Australia, ranging from Queensland, New South Wales and Victoria, venturing to the ground only to move to another tree."
                + "Koalas are mostly solitary, with males and females meeting only during mating season. "
                + "After nearly becoming extinct earlier in this century, koalas are now fully protected by the Australian government. ");
        animals.add(animal);

        animal = new Animal("Grant’s Zebra", "Equus quagga boehmi", "zebra.jpg");
        animal.setFullSizeImageFileName("zebraFullSize.jpg");
        animal.setDescription("Zebras, wild asses and Mongolian wild horses are found today only in Africa and Asia. "
                +"Zebras are swift runners and can travel up to 40 miles per hour. "
                + "In defense or competition for mates, they use their hind feet to kick, and can strike less skillfully with their forefeet."
                +"Grant’s zebra can be found in the grasslands, savannas and open country of Africa, including Southern Sudan and Ethiopia. "
                +"Grant’s zebras are also known as plains zebra or common zebra. ");
        animals.add(animal);
    }

}
