<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Jedrzej\Pimpable\PimpableTrait;

class Direction extends Model 
{
    use HasFactory, PimpableTrait;

    public $searchable = ['*'];
    public $sortable = ['*'];
    protected $withable = ['*'];

    /**
     * The attributes that are mass assignable.
     *
     * @var array
     */
    protected $fillable = [
        'map_id',
        'status',
    ];
}
