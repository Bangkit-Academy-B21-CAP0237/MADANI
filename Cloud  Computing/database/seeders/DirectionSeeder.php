<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class DirectionSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('directions')->insert([
            'map_id' => 1,
            'status' => 'after',
            'photo' => 'https://storage.googleapis.com/prediction_output/road/Map%20Desa%20Loli%20Pesua%20Kab%20Donggala%20After.png',
        ]);

        DB::table('directions')->insert([
            'map_id' => 2,
            'status' => 'before',
            'photo' => 'https://storage.googleapis.com/prediction_output/road/Map%20Desa%20Loli%20Pesua%20Kab%20Donggala%20Before.png',
        ]);

        DB::table('directions')->insert([
            'map_id' => 3,
            'status' => 'after',
            'photo' => 'https://storage.googleapis.com/prediction_output/road/Map%20Kelurahan%20Layana%20Indah%20Kota%20Palu%20After.png',
        ]);

        DB::table('directions')->insert([
            'map_id' => 4,
            'status' => 'before',
            'photo' => 'https://storage.googleapis.com/prediction_output/road/Map%20Kelurahan%20Layana%20Indah%20Kota%20Palu%20Before.png',
        ]);

        DB::table('directions')->insert([
            'map_id' => 5,
            'status' => 'after',
            'photo' => 'https://storage.googleapis.com/prediction_output/road/Map%20Kelurahan%20Lere%20Kota%20Palu%20After.png',
        ]);

        DB::table('directions')->insert([
            'map_id' => 6,
            'status' => 'before',
            'photo' => 'https://storage.googleapis.com/prediction_output/road/Map%20Kelurahan%20Lere%20Kota%20Palu%20Before.png',
        ]);

        DB::table('directions')->insert([
            'map_id' => 7,
            'status' => 'after',
            'photo' => 'https://storage.googleapis.com/prediction_output/road/Map%20Kelurahan%20Mamboro%20Kota%20Palu%20After.png',
        ]);

        DB::table('directions')->insert([
            'map_id' => 8,
            'status' => 'before',
            'photo' => 'https://storage.googleapis.com/prediction_output/road/Map%20Kelurahan%20Mamboro%20Kota%20Palu%20Before.png',
        ]);

        DB::table('directions')->insert([
            'map_id' => 9,
            'status' => 'after',
            'photo' => 'https://storage.googleapis.com/prediction_output/road/Map%20Kelurahan%20Silae%20Selatan%20Kota%20Palu%20After.png',
        ]);

        DB::table('directions')->insert([
            'map_id' => 10,
            'status' => 'before',
            'photo' => 'https://storage.googleapis.com/prediction_output/road/Map%20Kelurahan%20Silae%20Selatan%20Kota%20Palu%20Before.png',
        ]);

        DB::table('directions')->insert([
            'map_id' => 11,
            'status' => 'after',
            'photo' => 'https://storage.googleapis.com/prediction_output/road/Map%20Kelurahan%20Silae%20Utara%20Kota%20Palu%20After.png',
        ]);

        DB::table('directions')->insert([
            'map_id' => 12,
            'status' => 'before',
            'photo' => 'https://storage.googleapis.com/prediction_output/road/Map%20Kelurahan%20Silae%20Utara%20Kota%20Palu%20Before.png',
        ]);

        DB::table('directions')->insert([
            'map_id' => 13,
            'status' => 'after',
            'photo' => 'https://storage.googleapis.com/prediction_output/road/Map%20Kelurahan%20Tondo%20Selatan%20Kota%20Palu%20After.png',
        ]);

        DB::table('directions')->insert([
            'map_id' => 14,
            'status' => 'before',
            'photo' => 'https://storage.googleapis.com/prediction_output/road/Map%20Kelurahan%20Tondo%20Selatan%20Kota%20Palu%20Before.png',
        ]);

        DB::table('directions')->insert([
            'map_id' => 15,
            'status' => 'after',
            'photo' => 'https://storage.googleapis.com/prediction_output/road/Map%20Kelurahan%20Tondo%20Utara%20Kota%20Palu%20After.png',
        ]);

        DB::table('directions')->insert([
            'map_id' => 16,
            'status' => 'before',
            'photo' => 'https://storage.googleapis.com/prediction_output/road/Map%20Kelurahan%20Tondo%20Utara%20Kota%20Palu%20Before.png',
        ]);
    }
}
